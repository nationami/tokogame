/**
 * XYBASE Simple Data Grid, Extending a table as a data grid representation
 *
 * jQuery XYTable Plugins (Ported from xytable.js prototype version)
 * 
 * jquery.xytable.js v0.3
 * 
 * Developer: Imam Kurniawan <imam@xybase.com>
 * Copyright (c) 2010 XYBASE <http://www.xybase.com>
 */
(function($) {
    $.fn.xytable = function(options) {
        if (this.length === 0) {return this;}
        // has been created before
        var grid = $.data(this[0], 'xytable');
        if (this.length == 1 && grid) {return grid;}

        else {
            return this.each(function() {
                // set id and merge with custom options else will be xytable
                var id = $(this).attr('id'),
                    opt = $.extend({id: id}, options),
                    xytable = new $.xytable(opt);
                    
                $.data(this, 'xytable', xytable);
                return xytable;
            });
        }
    };

    // xytable constructor | public interface: $.tmpl
    $.xytable = function(options) {
        this.settings = $.extend(true, {}, $.xytable.defaults, options );
        this.table = $('#' + this.settings.id)[0];
        if ($(this.table).find('tbody').length === 0) {$(this.table).append('<tbody/>');}        
        this.Init();
    };
    

    // xytable class definition
    $.extend($.xytable, {
        defaults: {
            id: 'xytable',                              // table DOM id
            width: 0,					// table width not included rowcheck and rowcount @28px
            fontSize: '0',                              // override default font size which default value will be from css
            header: true,				// generate header based on colModel
            mapToForm: true,				// enable mapping to fields, property field must be provided in colModel
            mapOnCheck: false,				// mapping to fields when checkbox is click
            highlight: true,				// highlight when row is clicked
            highlightOnCheck: false,                    // highlight when checkbox is checked
            multiple: true,				// whether to generate checkbox or radio (true means checkbox)
            checkRow: true,				// whether to generate checkbox/radio
            rowCount: true,				// whether to generate row count
            clearOnSelect: false,			// clear checkbox selection when row clicked
            noSelect: false,				// disable row selection
            rowMarking: [-1, 0, 1],			// marking status when add/delete -1 is deleted, 0 is new, 1 is initial data
            rowAlternate: true,                         // add odd row with class ui-xytable-alternate
            cursor: 'pointer',                          // default cursor is hand (pointer)
            emptyMsg: 'No Data',			// display msg when no data
            contentControl: false,                      // Use content control column for edit/delete a row
            colModel: [],				// the column model array of object, array count match total columns excluding row check and row count
            gridOp: '.',
            data: false,                                // initial data (array of object)
            json: false,                                // data is in json string
            remote: false,                              // data is from a remote output
            checkboxMsg: 'Delete',
            idButtonDelete: '',							// enable button delete when checkbox is check
            idButtonClear: '',
            callback: {
                onSelect: function() {},                // this callback called when row is clicked
                onCheck: function() {},                 // this callback called when checkbox is clicked -1 if check-all clicked
                onAdd: function() {},                   // this callback called after add row
                onDelete: function() {},                // this callback called after delete row
                onAfterShift: function() {},            // this callback called after row shifting has been applied
                onBeforeShift: function()               // this callback called before row shifting has been applied
                    {return true;},                     // return true in case callback not exist in user's option
                onLoaded: function() {}                 // this callback called when table is loaded (processed)
            },
            pager: {					// pager object, when not empty will generate pagination
                id:'pager', base:'', pos: 'bottom',
                //enable goto
                gotopage: true,
                // offset, index of start record
                offset: 0,
                // page is current page, total is total pages, records is total records
                page: 1, total: 1, records: 1,
                // max is max page to be displayed, rows is maximum records to show
                max: 5, rows: 10,
                // param to be added to the generated url
                param: {},
                limitPages: true,
                showEdge: true, showSkip: false, showInactive: false, showInactiveNextPrev: false,
                ajax: false,
                callback : function() {}
            },
            sorter: false
        },
        messages : {
            'xytable.pager.info.tmpl'           : 'Showing #{first}-#{last} of #{total}',
            'xytable.pager.index.info'          : 'Pages:',
            'xytable.pager.index.first.title'   : 'First Page',
            'xytable.pager.index.first.label'   : 'First',
            'xytable.pager.index.last.title'    : 'Last Page',
            'xytable.pager.index.last.label'    : 'Last',
            'xytable.pager.index.next.title'    : 'Next Page',
            'xytable.pager.index.next.label'    : 'Next',
            'xytable.pager.index.prev.title'    : 'Previous Page',
            'xytable.pager.index.prev.label'    : 'Previous',
            'xytable.pager.index.skipnext.title': 'Skip Next #{skip} pages',
            'xytable.pager.index.skipnext.label': 'Skip Next',
            'xytable.pager.index.skipprev.title': 'Skip Previous #{skip} pages',
            'xytable.pager.index.skipprev.label': 'Skip Prev',
            'xytable.pager.index.page.title'    : 'Page #{page}',
            'xytable.pager.index.page.label'    : '#{page}',
            'xytable.pager.index.current.title' : 'Current Page',
            'xytable.pager.goto.label'          : 'Go to:'
        },
        prototype: {
            /**
             * Initialize xytable object
             */
            Init: function() {
                if (this.settings.colModel.length === 0) {throw "Please specify column model";}
                // initialize Data Model
                this.DataInit();
                // initialize DOM
                this.DOMInit();
                // initialize Events
                this.EventsInit();
                if (this.settings.callback.onLoaded) {
                    this.settings.callback.onLoaded.call(this, this.data);
                }
            },
            /**
             * Grab available data into array of object per row basis
             */
            DataInit: function() {
                var jsonObj, url, data = [], that = this,
                    colModel = this.settings.colModel;
                // get data from array
                if (this.settings.data) {
                    that.PopulateData(this.settings.data);
                } else
                // or get data from json
                if (this.settings.json && /^1\.4/.test($.fn.jquery)) {
                    jsonObj = $.parseJSON(this.settings.json);
                    this.PopulateData(jsonObj.data);
                } else
                // or get data from remote json
                if (this.settings.remote) {
                    url = this.settings.remote.url;
                    $.ajax({
                        url:        url || '',
                        type:       'GET', data: {}, cache: false, value: '', remote: true,
                        dataType:   'json',
                        success: function(resp) {
                            var respData = resp[this.settings.remote.key || 'data'];
                            that.PopulateData(respData);
                        }
                    });
                }
                
                // get data from html
                $.each($(this.table).find('tbody tr'), function() {
                    var obj = {},
                        d = $(this).find('td').map(function() {
                            return $(this).text();
                        });
                    $.each(d, function(i) {
                        var k = colModel[i].name;
                        obj[k] = this.toString();
                    });
                    data.push(obj);
                });
                this.data = data;
            },
            /**
             * Initialize DOM for xytable
             */
            DOMInit: function() {                
                var i, head, style, colHeader = '', label = '',
                    totalWidth = 0, countWidth = 0, offset = 0,
                    colModel = this.settings.colModel,
                    gridId = this.settings.id,
                    table = this.table,
                    colSpan = 1, rowSpan = 1,
                    rows = $(table).find('tbody tr'),
                    ids = '', sorter, headerSorter = {};
                // identify skip cols
                this.skip = 0;
                this.skip += this.settings.rowCount ? 1 : 0;
                this.skip += this.settings.checkRow ? 1 : 0;

                // wrapping, adding class, alternating to tables                
                if (this.settings.rowAlternate) {$(table).find('tbody tr:odd').addClass('ui-xytable-alternate');}
                $(table).wrap('<div class="ui-xytable-wrapper" id="'+gridId+'-wrapper"></div>');

                // creating columns header
                if (this.settings.header) {
                    $.each(colModel, function(i) {
                        style = '';
                        if (this.width) {style += 'width:' + (!$.browser.safari ? this.width : (this.width+15)) + 'px;';}
                        if (this.hidden) {style += 'display:none;';}
                        
                        label = this.label||'Column'+(i+1);
                        if (this.bindToCheck) {
                            label += (!label.empty()?'<br/>':'')+'<input type="checkbox" id="'+gridId+'-chk-all-col'+i+'"/>';
                        }
                        colHeader += '<th class="' + (this.align || '') + ' "style="' + style + '">' + label + '</th>';
                        totalWidth += this.width || 0;
                    });
                    totalWidth = (this.settings.width && this.settings.width > totalWidth) ? this.settings.width : totalWidth;
                    // add generated column width (count and/or check)
                    totalWidth += (this.skip * 25);
                    // assign table width
                    if (totalWidth > 0) {$(table).addClass('ui-xytable').attr('width', '100%');}
                    // put headers
                    $(table).prepend('<thead><tr></tr></thead>').find('thead tr').append(colHeader).addClass('ui-xytable-header');
                    this.thead = $(table).find('thead');
                }
				
                // prosess overriden header
                else {
                    head = $(table).find('thead');
                    rowSpan = head.find('tr').length;
                    if (head.length > 0) {head.find('tr').addClass('ui-xytable-header');}
                }									
				
                // providing reference for header and body
                this.thead = $(table).find('thead');
                this.tbody = $(table).find('tbody');
                this.pager = $('#'+this.settings.pager.id);
                this.wrapper = $('#'+gridId+'-wrapper');

                if (totalWidth > 0) {this.pager.css({'width': '98%'});}
                if (this.pager.length > 0 && this.data.length > 0) {
                    // pager at bottom then move pager into wrapper and apply workaround for IE7
                    if (this.settings.pager.pos === 'bottom') {
                        this.wrapper.append(this.pager);
                        if ($.browser.msie) {this.wrapper.append('<div class="after-pager-ie-workaround"></div>');}
                    }
                    // pager at top then move pager into wrapper
                    else {this.wrapper.prepend(this.pager);}
                }
				
                // processing hidden
                rows.each(function(i, tr) {
                    var tds = $(tr).find('td');
                    $(tr).attr('_idx', i);
                    $.each(colModel, function(i) {
                        var td = $(tds[i]);
                        // column should be hidden
                        if (this.hidden) {$(tds[i]).hide();}
                        // column is considered as row id
                        if (this.id) {
                            //td.prepend('<input type="hidden" name="'+this.name+'" value="'+$(td).text()+'"/>');
                            ids += '<input type="hidden" name="'+this.name+'" value="'+$(td).text()+'"/>';
                            td.attr('rel', 'id');
                        }
                        // text aligning
                        if (this.align) {
                            switch(this.align) {
                                case 'right' : case 'left' : case 'center' :
                                    td.addClass(this.align);
                                    break;
                            }
                        }
                    });
                });

                // put hidden ids in wrapper
                this.wrapper.append('<div style="display:none;">'+ids+'</div>');

                // if has pager then initialize it now
                if (this.pager.length > 0) {this.PagerInit();}
					
                // row count
                if (this.settings.rowCount) {
                    offset = parseInt(this.settings.pager.offset, 10);
                    countWidth = offset > 999 ? ($.browser.safari ? 45 : 35) : 0;
                    
                    this.thead.find('tr').prepend('<th class="count center" rowSpan="'+rowSpan+'">No</th>');
                    if (countWidth > 0) {$(this.thead.find('th.count').get(0)).css({'width': countWidth});}

                    rows.each(function(i) {
                        var count = i + 1;
                        if (offset) {count += offset;}
                        $(this).prepend('<td class="count center">'+count+'</td>');                        
                    });
                }
				
             // checkboxes
                if (this.settings.multiple && this.settings.checkRow) {                	
                    this.thead.find('tr').prepend('<th class="check center" rowSpan="'+rowSpan+'">'+this.settings.checkboxMsg+'<input type="checkbox" id="'+gridId+'-chk-all"   class="ui-xytable-control"/></th>');
                    var checkboxMsg = this.settings.checkboxMsg;
                    rows.each(function(i) {
                        var idTd = $(this).find('td[rel=id]'),
                            idValue = idTd.length > 0 ? $(idTd).text() : (i + 1);
                            if(checkboxMsg=="Delete")    
                            	$(this).prepend('<td class="check center padding-left"><input type="checkbox" class="ui-xytable-control" name="'+gridId+'ChkList" value="'+idValue+'"/></td>');
                            else
                            	$(this).prepend('<td class="check center"><input type="checkbox" class="ui-xytable-control" name="'+gridId+'ChkList" value="'+idValue+'"/></td>');
                    });
                }
                // radiobuttons
                else if (this.settings.checkRow) {
                    this.thead.find('tr').prepend('<th class="radio" rowSpan="'+rowSpan+'">&nbsp;</th>');
                    rows.each(function(i) {
                        var idTd = $(this).find('td[rel=id]'),
                            idValue = idTd.length > 0 ? $(idTd).val() : (i + 1);
                        $(this).prepend('<td class="radio center"><input type="radio" name="'+gridId+'Rdo" value="'+idValue+'"/></td>');
                    });
                }
				
                // if no data show empty msg
                if (rows.length === 0) {
                    colSpan = this.thead.find('th').length;
                    this.tbody.append('<tr class="ui-xytable-empty-row"><td colSpan="'+colSpan+'">'+this.settings.emptyMsg+'</td></tr>');
                    this.DisableCheck();
                }
                // if has data then set row index
                else {rows.each(function(i) {this._idx = i;});}

                // adjust font size when fontSize setting is provided
                if (this.settings.fontSize && this.settings.fontSize !== '' && this.settings.fontSize !== '0') {
                    $(this.thead).parents('table').find('th, td').css({'font-size': this.settings.fontSize});
                }
                // apply sorter if config defined and grid not empty
                if (this.settings.sorter && rows.length > 0) {
                    for(i = 0; i < this.skip; i++) {
                        headerSorter[i] = {sorter: false};
                    }
                    sorter = $.extend(true, {headers : headerSorter}, this.settings.sorter);
                    $('#'+this.settings.id).tablesorter(sorter);
                }
            },
            /*
             * Initialize all xytable events (row click, checkbox/checkbox all click)
             */
            EventsInit: function() {
                var xytable = this,
                    data = xytable.data,
                    settings = xytable.settings,
                    mapToForm = function() {},
                    selectCheckRow = function() {};

                mapToForm = function(row) {
                    var colModel = settings.colModel;

                    $(row).find('td').each(function(i, c) {
                        if (i < xytable.skip) {return;}

                        var elt, idx = i - xytable.skip,
                            v = $(c).text(),
                            eltId = (colModel[idx]).field;
                            
                        if ( eltId && eltId !== '') {
                            // get element's jQuery Object
                            elt = $('#' + eltId);
                            if (elt.length === 0) {elt = $('input[name='+eltId+']');}

                            // checkbox
                            if (elt.is(':checkbox')) {
                                elt[0].checked = v === 'Y' || v === 'true' || v === '1';
                            }
                            // radio buttons select by name so could be more than 1
                            else if (elt.length >= 1 && $(elt[0]).is(':radio')) {
                                elt.each(function() {
                                    this.checked = $(this).val() == v;
                                });
                            }
                            // select
                            else if (elt.is('select')) {elt.val(v.split(','));}
                            // text|hidden|password input, textarea or select
                            else {elt.val(v);}
                        }
                    });
                };
				
                selectCheckRow = function(e) {
                    var idx, check, checked, rows,
                        row = $(e.target).is('td') ? $(e.target).parents('tr') : e.target;

                    idx = $(row).attr('_idx');
                    if ($(e.target).is(':checkbox')) {
                        // checkall is clicked
                        if ($(e.target).is(':checkbox[id$=chk-all].ui-xytable-control')) {
                            // checked or not
                            check = e.target.checked;
                            // apply checked or not
                            $(row).parents('table').find(':checkbox.ui-xytable-control').each(function () {
                                this.checked = check;
                            });
                            // call onCheck callback
                            settings.callback.onCheck.call(xytable, check, data, -1);
                        }
                        // single checkbox is clicked
                        else {
                            // map row values to form field
                            if (settings.mapToForm && settings.mapOnCheck) {mapToForm.call(e.target, row);}
                            
                            // highlight
                            if (settings.highlightOnCheck) {xytable.Highlight.call(e.target, idx);}
                            
                            // apply check/uncheck all if checkbox click
                            if ($(e.target).is(':checkbox')) {
                                // count total rows
                                rows = $(row).parents('tbody').find('tr').length;
                                // count total cheked
                                checked = $(e.target).parents('tbody').find(':checkbox.ui-xytable-control[checked]').length;
                                    
                                // check all if rows equal to checked
                                $(e.target).parents('table')
                                       .find('thead :checkbox.ui-xytable-control')
                                       .get(0).checked = (checked == rows);
                            }
                                   
                            // call onCHeck callback
                            settings.callback.onCheck.call(xytable, checked > 0, data[parseInt(idx, 10)], idx);
                        }
                        // Added by edy rakhman
                        $(':checkbox').each(function() {
		    			    var lengthTD = $('#'+settings.id+' tbody tr td').length;
					        if($(this).parent().parent().attr('class')!='ui-xytable-header') {
						        if($(this).is(':checked')) {
						        	for (var i=0; i<lengthTD; i++) {
						        		$(this).parent().parent().children().eq(i).css('background-color','#FFE87C');
    						        }
						        }
						        else {
						        	for (var i=0; i<lengthTD; i++) {
					        			$(this).parent().parent().children().eq(i).css('background-color','');
    						        } 
						        }
					        }
					 	});
                        if ($('input:checkbox:checked[name="'+settings.id+'ChkList"]').length > 0) {
					 		$('#'+settings.idButtonDelete).removeAttr('disabled');
    					} else {
    						$('#'+settings.idButtonDelete).attr('disabled','disabled');	
        				}
                    }
                    // Cell selection, highlight and/or map to form
                    else {
                        // map row values to form field
                        if (settings.mapToForm) {mapToForm.call(e.target, row);}
                        
                        // highlight when applicable
                        if (settings.highlight && !$(e.target).is('th')) {xytable.Highlight.call(e.target, idx);}
                        
                        // check if needs to clear check on select
                        if (settings.clearOnSelect) {xytable.ClearCheck();}
                        
                        // Call user's onSelect callback function
                        settings.callback.onSelect.call(xytable, xytable.data[parseInt(idx, 10)], idx);
                    }
                };                

                // Event handler for selecting/check row
                $('#'+settings.id).live('click', selectCheckRow);
                
                // Re-Order row count when after sorting
                if (settings.sorter) {
                    $('#'+settings.id).bind("sortEnd", function() {
                        $('#'+settings.id).find('tbody tr.ui-xytable-alternate').removeClass('ui-xytable-alternate');
                        $('#'+settings.id).find('tbody tr:odd').addClass('ui-xytable-alternate');
                        $('#'+settings.id).find('tbody tr').each(function(i, r) {
                            var count = i + 1;
                            if (settings.rowCount) {$(r).find('td.count').text(count+'.');}
                        });
                    });
                }
            },
            /**
             * Initialize Pagination Support
             */
            PagerInit: function() {
                var i, x, y, lower, higher, prop,
                    gotoStr = '', infoStr = '', links = '', paramIsEmpty = true,
                    // pager options
                    opts = this.settings.pager,
                    // pager index anchor template
                    link_tmpl = '<a href="#{href}" title="#{title}" class="#{clazz}">#{text}</a>',
                    // pager info template
                    info_tmpl = $.xytable.messages['xytable.pager.info.tmpl'],
                    // offset of grid operator (java ussualy used . (dot) but php should use _ (uderscore))
                    gridOp = this.settings.gridOp || '.',
                    // pager container
                    container = $('#'+opts.id),                    
                    // get base parameters in query string as object to be merged with user param
                    url, baseParam = opts.base.indexOf('?') !== -1 ?
                            $.deparam(opts.base.substr(opts.base.indexOf('?')+1, opts.base.length)) : {},
                    // merge base param with user's param
                    param = $.extend({}, opts.param, baseParam);

                for(prop in opts.param) {
                    if(opts.param.hasOwnProperty(prop)) {paramIsEmpty = false;}
                }

                param[this.settings.id+gridOp+'offset'] = '';
                // compose pagination url query string
                url = (paramIsEmpty ? '' : opts.base) + opts.base.substr(0, opts.base.indexOf('?')) + '?' + $.param(param);

                // get current page and total available records as number (integer)
                opts.page = parseInt(opts.page, 10);
                opts.records = parseInt(opts.records, 10);
                // count offset and total page
                opts.offset = (opts.page*opts.rows)-opts.rows;
                opts.total = Math.ceil(opts.records/opts.rows);

                x = 1;y = opts.total > opts.max && opts.limitPages ? opts.max : opts.total;
                // Build pager if total pages more than 1
                if ((opts.total > opts.max) && opts.limitPages) {
                    lower = opts.page - Math.floor(opts.max/2);
                    higher = opts.page + Math.floor(opts.max/2);

                    if (lower > 0 && opts.total > opts.max) {x = lower;}
                    if (higher > opts.total-1)  {x = x-(higher-opts.total);}
                    if (higher < opts.total && higher > opts.max && opts.total > opts.max) {y = opts.max % 2 !== 0 ? higher : higher-1;}
                    else if (higher > opts.total-1) {y = opts.total;}
                }

                // first page
                if (opts.page != 1 && opts.showEdge) {
                    links += $.tmpl(link_tmpl, {
                        href: url + '0',
                        clazz: 'pager-link nav',
                        title: $.xytable.messages['xytable.pager.index.first.title'],
                        text: $.xytable.messages['xytable.pager.index.first.label']
                    });
                }
                // already on first page
                else if (opts.showEdge) {
                    links += $.tmpl(link_tmpl, {
                        href: '#',
                        clazz: 'pager-link nav edge inactive',
                        title: $.xytable.messages['xytable.pager.index.first.title'],
                        text: $.xytable.messages['xytable.pager.index.first.label']
                    });
                }
                // skip previous max pages
                if ((opts.page - opts.max) > 0 && opts.showSkip) {
                    links += $.tmpl(link_tmpl, {
                        href: url + (opts.offset - (opts.rows * opts.max)),
                        clazz: 'pager-link nav',
                        title: $.tmpl($.xytable.messages['xytable.pager.index.skipprev.title'], {skip: opts.max}),
                        text: $.tmpl($.xytable.messages['xytable.pager.index.skipprev.label'], {skip: opts.max})
                    });
                }
                // no previous max pages available
                else if (opts.showSkip) {
                    links += $.tmpl(link_tmpl, {
                        href: '#',
                        clazz: 'pager-link nav inactive',
                        title: $.tmpl($.xytable.messages['xytable.pager.index.skipprev.title'], {skip: opts.max}),
                        text: $.tmpl($.xytable.messages['xytable.pager.index.skipprev.label'], {skip: opts.max})
                    });
                }
                // previous page
                if (opts.page > 1) {
                    links += $.tmpl(link_tmpl, {
                        href: url + (opts.offset - opts.rows),
                        clazz: 'pager-link nav',
                        title: $.xytable.messages['xytable.pager.index.prev.title'],
                        text: $.xytable.messages['xytable.pager.index.prev.label']
                    });
                }
                // no previous page available
                else {
                    links += $.tmpl(link_tmpl, {
                        href: '#',
                        clazz: 'pager-link nav nextprev inactive',
                        title: $.xytable.messages['xytable.pager.index.prev.title'],
                        text: $.xytable.messages['xytable.pager.index.prev.label']
                    });
                }

                // display available page index label
                if (y > 1) {links += '&nbsp;<span>'+$.xytable.messages['xytable.pager.index.info']+'</span>&nbsp;';}
                // available pages
                for (i = x; i <= y; i++) {
                    links += $.tmpl(link_tmpl, {
                        href: url + ((i-1) * opts.rows),
                        clazz: opts.page === i ? 'pager-link current inactive' : 'pager-link',
                        title: opts.page === i ? $.xytable.messages['xytable.pager.index.current.title'] : $.tmpl($.xytable.messages['xytable.pager.index.page.title'], {page: i}),
                        text: $.tmpl($.xytable.messages['xytable.pager.index.page.label'], {page: i})
                    });
                }

                // next page
                if (opts.page < opts.total) {
                    links += $.tmpl(link_tmpl, {
                        href: url + (opts.offset + opts.rows),
                        clazz: 'pager-link nav',
                        title: $.xytable.messages['xytable.pager.index.next.title'],
                        text: $.xytable.messages['xytable.pager.index.next.label']
                    });
                }
                // no next pages available
                else {
                    links += $.tmpl(link_tmpl, {
                        href: '#',
                        clazz: 'pager-link nav nextprev inactive',
                        title: $.xytable.messages['xytable.pager.index.next.title'],
                        text: $.xytable.messages['xytable.pager.index.next.label']
                    });
                }
                // skip next max pages
                if ((opts.page + opts.max) < opts.total && opts.showSkip) {
                    links += $.tmpl(link_tmpl, {
                        href: url + (opts.offset + (opts.rows * opts.max)),
                        clazz: 'pager-link nav',
                        title: $.tmpl($.xytable.messages['xytable.pager.index.skipnext.title'], {skip: opts.max}),
                        text: $.tmpl($.xytable.messages['xytable.pager.index.skipnext.label'], {skip: opts.max})
                    });
                }
                // no next max pages available
                else if (opts.showSkip) {
                    links += $.tmpl(link_tmpl, {
                        href: '#',
                        clazz: 'pager-link nav inactive',
                        title: $.tmpl($.xytable.messages['xytable.pager.index.skipnext.title'], {skip: opts.max}),
                        text: $.tmpl($.xytable.messages['xytable.pager.index.skipnext.label'], {skip: opts.max})
                    });
                }
                // last page
                if (opts.page != opts.total && opts.showEdge) {
                    links += $.tmpl(link_tmpl, {
                        href: url + (opts.rows * (opts.total - 1)),
                        clazz: 'pager-link nav',
                        title: $.xytable.messages['xytable.pager.index.last.title'],
                        text: $.xytable.messages['xytable.pager.index.last.label']
                    });
                }
                // already on last page
                else if (opts.showEdge) {
                    links += $.tmpl(link_tmpl, {
                        href: '#',
                        clazz: 'pager-link nav edge inactive',
                        title: $.xytable.messages['xytable.pager.index.last.title'],
                        text: $.xytable.messages['xytable.pager.index.last.label']
                    });
                }

                // attach pager index
                infoStr = $.tmpl(info_tmpl, {
                    first: opts.offset + 1,
                    last: opts.records > opts.offset+opts.rows ? opts.offset+opts.rows : opts.records,
                    total: opts.records,
                    pages: opts.total
                });

                container.addClass('ui-xytable-pager');
                container.append('<div class="info">'+ infoStr +'</div>');
                container.append('<div class="index">'+ links +'</div>');
                
                // hide by default
                container.find('a.inactive:not(.current)').hide();

                // show inactive links
                if (opts.showInactive) {container.find('a.inactive').show();}
                // show inactive nextprev only
                else if (opts.showInactiveNextPrev) {container.find('a.nextprev.inactive').show();}
               
                if (opts['gotopage']) {
                    gotoStr = $.xytable.messages['xytable.pager.goto.label']+'&nbsp;<input type="text" class="field goto" id="'+this.settings.id+'Goto"/>';
                    container.find('.index').append(gotoStr);
                    // listen to keyup event on goto field
                    $('#'+this.settings.id+'Goto').keyup(function(e) {
                        var val, ch = String.fromCharCode(e.keyCode);
                        // reject if not number and enter key
                        if (!/[\d]/.test(ch) && e.keyCode !== 13) {
                            if (!/[\d]/.test(ch)) { // revert value if not number entered
                                $(this).val($(this).val().substr(0, $(this).val().length-1));
                            }
                        }
                        // enter key detected
                        if (e.keyCode === 13) {                            
                            val = $(this).val() > opts.total ? opts.total : $(this).val();
                            // setup offset value
                            url += (val * opts.rows) - opts.rows;
                            // when ajax call callback
                            if (opts.ajax) {opts.callback(url);}
                            // common redirect
                            else {location.href = url;}
                        }
                    });
                }

                // attach event click to navigation link
                container.find('a.pager-link').click(function(e) {
                    if ($(this).is('.inactive')) {return false;}
                    // call ajax pagination callback
                    if (opts.ajax) {
                        opts.callback.call(opts, this.href);
                        return false;
                    }
                    // form submited pagination
                    else if (opts.form) {
                        $('#'+opts.form).attr('action', this.href);
                        $('#'+opts.form).trigger('submit');
                        return false;
                    }
                });

                // hide if no data
                if (this.data.length === 0 || opts.records <= opts.rows) {container.hide();}
            },
            Highlight: function(idx) {                
                var row = $(this).parents('table').find('tr').get(idx+1);
                if (!row) {row = $(this.table).find('tbody tr').get(idx);}
                $(row).parents('table').find('tr.ui-xytable-highlight').removeClass('ui-xytable-highlight');
                $(row).addClass('ui-xytable-highlight');
            },
            ClearCheck: function() {
            	var lengthTD = $('#'+this.settings.id+' tbody tr td').length;
            	$('#'+this.settings.id).find(':checkbox.ui-xytable-control').each(function() {
                	this.checked = false;
    		        if($(this).parent().parent().attr('class')!='ui-xytable-header') {
    		        	for (var i=0; i<lengthTD; i++) {
    	        			$(this).parent().parent().children().eq(i).css('background-color','');
    			        } 
    		        }
                });
            },
            ClearHighlight: function() {
                $('#'+this.settings.id).find('.ui-xytable-highlight').removeClass('ui-xytable-highlight');    
            },
            ClearHighlightedCheck: function() {
            	this.ClearHighlight();
            	this.ClearCheck();
            },
            DisableCheck: function() {
                $('#'+this.settings.id).find(':checkbox..ui-xytable-control, :radio.ui-xytable-control')
                    .each(function() {this.disabled = true;});
            },
            EnableCheck: function() {
                $('#'+this.settings.id).find(':checkbox..ui-xytable-control, :radio.ui-xytable-control')
                    .each(function() {this.disabled = false;});
            },
            ShiftRowUp: function() {
                // selected row to be shifted
                var selected = $('#'+this.settings.id).find('tbody tr').map(function() {
                    if ($(this).find(':checkbox.ui-xytable-control').get(0).checked) {return this;}
                });
                if (this.settings.callback.onBeforeShift.call(this, selected)) {
                    this.ShiftRow('up', selected);
                    this.settings.callback.onAfterShift.call(this, 'up', selected);
                }
            },
            ShiftRowDown: function() {
                // selected row to be shifted
                var selected = $('#'+this.settings.id).find('tbody tr').map(function() {
                    if ($(this).find(':checkbox.ui-xytable-control').get(0).checked) {return this;}
                });
                if (this.settings.callback.onBeforeShift.call(this, selected)) {
                    this.ShiftRow('down', selected);
                    this.settings.callback.onAfterShift.call(this, 'down', selected);
                }
            },
            ShiftRow: function(dir, selected) {
                var settings = this.settings;
                // shift up
                if (dir === 'up') {
                    // shift 'em
                    $.each(selected, function() {
                        if ($(this).prev().length > 0) {$(this).prev().before(this);}
                        else {return false;}
                    });
                }
                //  shift down
                else if (dir === 'down') {
                    // reverse selected
                    selected = $.makeArray(selected).reverse();
                    // shift 'em
                    $.each(selected, function() {
                        if ($(this).next().length > 0) {$(this).next().after(this);}
                        else {return false;}
                    });
                }
                // fix count & alternating rows
                $('#'+settings.id).find('tbody tr.ui-xytable-alternate').removeClass('ui-xytable-alternate');
                $('#'+settings.id).find('tbody tr:odd').addClass('ui-xytable-alternate');
                $('#'+settings.id).find('tbody tr').each(function(i, r) {
                    var count = i + 1;
                    if (settings.rowCount) {$(r).find('td.count').text(count+'.');}
                });
            },
            SetEmptyMsg: function(msg) {
                if (this.data.length === 0) {if (msg) {this.settings.emptyMsg = msg;}$('#'+this.settings.id).find('tbody td').text(this.settings.emptyMsg);}
            },
            PopulateData: function(data, noMerge) {
                var rows = '', colModel = this.settings.colModel, noMerge = noMerge || false;

                if (!noMerge) {this.data = $.merge(this.data, data);} else {this.data = data;}
                $.each(this.data, function() {
                    var row = this, td = '';
                    $.each(colModel, function() {
                        td += '<td>' + row[this.name] + '</td>';
                    });
                    rows += '<tr>' + td + '</tr>';
                });
                
                $(this.table).find('thead').remove();
                $(this.table).find('tbody').html(rows);
                // initialize Data Model
                this.DataInit();
                // initialize DOM
                this.DOMInit();
            },
            AddRow: function(data) {                
                if (!(data instanceof Array)) {data = [data];}
                this.PopulateData(data);
            },
            DeleteRow: function(rowIdx) {
                var newData = [];
                if (!rowIdx) {
                    rowIdx = $('#'+this.settings.id).find('tbody tr').map(function(i) {
                        if ($(this).find(':checkbox.ui-xytable-control').get(0).checked) { return i; }
                    });
                    rowIdx = $.map(rowIdx, function(x) { return x; });
                }
                if (!(rowIdx instanceof Array)) { rowIdx = [rowIdx]; }
                $.each(this.data, function(i) {
                    if ($.inArray(i, rowIdx) === -1) { newData.push(this); }
                });
                this.PopulateData(newData, true);
            },
            // Update By Edy Rakhman
            DeleteRowAll: function() {
            	var rowCount = $('#'+this.settings.id+' tr').length;
				var indexArr = [];
				for (var i=0; i<rowCount-1; i++) {
					indexArr.push(i);	
				}
				this.DeleteRow(indexArr);
            }
            
        }
        
        
    });
    
})(jQuery);