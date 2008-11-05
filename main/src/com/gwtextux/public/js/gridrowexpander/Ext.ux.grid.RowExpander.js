/**
*    RowExpander changed from RowExpander.js in the Ext examples and some ideas taken
*    from the forum (http://extjs.com/forum/showthread.php?t=21017&page=3).
*
*    Override the createExpandingRowPanelItems function to make Ext expanded row content
*    (as opposed to using Ext.Template to make the expanded row content).
*
*    If config.store is passed in, pass a record for the row from that store instead
*    of the grid store into the createExpandingRowPanelItems function.
*/

/*global Ext */

Ext.ns('Ext.ux.grid');
Ext.ux.grid.RowExpander = function(config){
    Ext.apply(this, config);

    this.state = {};

    this.addEvents({
        beforeexpand : true,
        expand: true,
        beforecollapse: true,
        collapse: true
    });
    
    Ext.ux.grid.RowExpander.superclass.constructor.call(this);
};

Ext.extend(Ext.ux.grid.RowExpander, Ext.util.Observable, {
    header: "",
    width: 20,
    sortable: false,
    fixed:true,
    dataIndex: '',
    id: 'expander',
    lazyRender : true,
    enableCaching: true,
    menuDisabled: true,

    getRowClass : function(record, rowIndex, rowParams, ds){
        // cols: The column count to apply to the body row's TD colspan attribute (defaults to the current column count of the grid).
        rowParams.cols = rowParams.cols-1; // make it the width of the whole row
        return this.state[record.id] ? 'x-grid3-row-expanded' : 'x-grid3-row-collapsed';
    },

    init : function(grid){
        this.grid = grid;
		
        var view = grid.getView();
        view.getRowClass = this.getRowClass.createDelegate(this);

        view.enableRowBody = true;
        
        //recreate component when it was expanded and row was changed, the component must then change as well
		view.on("rowupdated", function(gridView, rowIndex, record){
			var row = gridView.getRow(rowIndex);
        	if(Ext.fly(row).hasClass('x-grid3-row-expanded')){
        			this.expandRow(rowIndex);
            	}
        },this);
        
        //recreate component when it was expanded and grid was refreshed  
        view.on("refresh", function(grid){
        	var aRows = this.grid.getView().getRows();
        	for(var i = 0; i < aRows.length; i++) {
        		if(Ext.fly(aRows[i]).hasClass('x-grid3-row-expanded')){
            		this.expandRow(aRows[i].rowIndex);
            	}
        	}
        	/*var panel = this.expandingRowPanel[record.id];
        	var row = this.grid.view.getRow(panel.rowIndex);
        	
        	if(panel){
        		// if using additional store passed in config, pass record from it instead of from the grid store
        		var rowBody = panel.renderTo;
        		var rowIndex = panel.rowIndex;
        		this.state[record.id] = false;
            	Ext.fly(row).replaceClass('x-grid3-row-expanded', 'x-grid3-row-collapsed');
            	this.fireEvent('collapse', this, record, rowBody, row.rowIndex);
        		//this.expandRow(rowIndex);
        		//this.createExpandingRowPanel(record, rowBody, rowIndex);
        	}*/
        },this);

        grid.on('render', function(){
            view.mainBody.on( 'mousedown', this.onMouseDown, this );
        }, this);

        // store
 /*       this.grid.getStore().on("load", function(store, records, options){
            Ext.select('div.x-grid3-row-expanded').replaceClass('x-grid3-row-expanded', 'x-grid3-row-collapsed');
            this.state = {};
            }, this);
*/
		this.store = this.store ? this.store : this.grid.store;
        this.store.load(); // load here instead of in beforeExpand cuz that would wipe out additions to store
    },

    onMouseDown : function( e, t ) {
        if(t.className == 'x-grid3-row-expander'){
            e.stopEvent();
            var row = e.getTarget('.x-grid3-row');
            this.toggleRow(row);
        }
    },

    renderer : function(v, p, record){
        p.cellAttr = 'rowspan="2"';
        return '<div class="x-grid3-row-expander">&#160;</div>';
    },

    beforeExpand : function(record, rowBody, rowIndex){
        var isContinue = true;
        if(this.fireEvent('beforeexpand', this.grid, record, rowIndex) !== false){
            if(rowBody.innerHTML == '' || !this.enableCaching) {
                this.createExpandingRowPanel( record, rowBody, rowIndex );
            }
        } else {
            isContinue = false;
        }

        return isContinue;
    },

    toggleRow : function(row){
        if(typeof row == 'number'){
            row = this.grid.view.getRow(row);
        }
        this[Ext.fly(row).hasClass('x-grid3-row-collapsed') ? 'expandRow' : 'collapseRow'](row);
    },

    expandRow : function(row){
        if(typeof row == 'number'){
            row = this.grid.view.getRow(row);
        }
        var record = this.store.getAt(row.rowIndex);
        // if using additional store passed in config, pass record from it instead of from the grid store
        var rowBody = Ext.DomQuery.selectNode('tr:nth(2) div.x-grid3-row-body', row);
        if(this.beforeExpand(record, rowBody, row.rowIndex)){
        	
            this.state[record.id] = true;
            Ext.fly(row).replaceClass('x-grid3-row-collapsed', 'x-grid3-row-expanded');
            this.fireEvent('expand', this.grid, record, row.rowIndex);
        }
    },

    collapseRow : function(row){
        if(typeof row == 'number'){
            row = this.grid.view.getRow(row);
        }
        var record = this.store.getAt(row.rowIndex);
        // if using additional store passed in config, pass record from it instead of from the grid store
        var body = Ext.fly(row).child('tr:nth(1) div.x-grid3-row-body', true);
        if(this.fireEvent('beforecollapse', this, record, body, row.rowIndex) !== false){
            this.state[record.id] = false;
            Ext.fly(row).replaceClass('x-grid3-row-expanded', 'x-grid3-row-collapsed');
            this.fireEvent('collapse', this, record, body, row.rowIndex);
        }
    },

	// Expand all rows
    expandAll : function() {
        var aRows = this.grid.getView().getRows();
        for(var i = 0; i < aRows.length; i++) {
            this.expandRow(aRows[i]);
        }
    },

    // Collapse all rows
    collapseAll : function() {
        var aRows = this.grid.getView().getRows();
        for(var i = 0; i < aRows.length; i++) {
            this.collapseRow(aRows[i]);
        }
    },


   createExpandingRowPanel: function( record, rowBody, rowIndex ) {

        // record.id is more stable than rowIndex for panel item's key; rows can be deleted.
        var panelItemIndex = record.id;
        // var panelItemIndex = rowIndex;

        // init array of expanding row panels if not already inited
        if ( !this.expandingRowPanel ) {
            this.expandingRowPanel = [];
        }

        // Add a new panel to the row body if not already there
        if ( this.expandingRowPanel[panelItemIndex] ) {
        	Ext.destroy(this.expandingRowPanel[panelItemIndex]);
        }
            this.expandingRowPanel[panelItemIndex] = new Ext.Panel(
                {
                    // title: 'Custom Fields',
                     layout:'fit', // this doesn't put the labels there
                    border: false,
                    bodyBorder: false,
                    hideBorders: true,
                    frame: false,
                    width: 'auto',
                    //layout:'form',
                    renderTo: rowBody,
                    monitorResize: true,
                    deferredRender: true,
                    items: this.createExpandingRowPanelItems( this.grid, this.store, record, rowIndex )
                }
            );
            
            //prevents from propagating these events up to parent grid
            this.expandingRowPanel[panelItemIndex].getEl().swallowEvent([
                         'click', 'mousedown','keydown','mouseover',
                        'contextmenu', 
                        'dblclick'
                    ],true); 
            
        
    }/*,

    /**
    * Override this method to put Ext form items into the expanding row panel.
    * @return Array of panel items.
    *
    createExpandingRowPanelItems: function( record, rowIndex ) {
        var panelItems = new Ext.Panel({
//	renderTo: rowBody,
	width: '200px',
	title: 'My Title',
	html: 'My HTML content'
});

        return panelItems;
    }
*/
});
// registre xtype
Ext.reg('rowexpander', Ext.ux.grid.RowExpander);



