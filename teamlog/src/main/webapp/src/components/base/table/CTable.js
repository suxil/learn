import React from 'react';
import PropTypes from 'prop-types';
import commonProps from '../../../common/CommonProps';
import {connect} from 'dva/index';

import {
    Table
} from 'antd';

class CTable extends React.Component {
    handleTableChange = (pagination, filters, sorter) => {
        const pager = { ...this.state.pagination };
        pager.current = pagination.current;
        this.setState({
            pagination: pager,
        });
        this.fetch({
            results: pagination.pageSize,
            page: pagination.current,
            sortField: sorter.field,
            sortOrder: sorter.order,
            ...filters,
        });
    }

    render () {
        const props = this.props;
        const {
            dispatch,
            namespaceType,
            dataSource,
            columns,
            total,
            bordered,
            onRow,
            // rowKey,
            rowSelection,
            scroll,
            loading,
            align,
            onChange
        } = props;

        const tableProps = {
            ...commonProps.tableProps,
            ...props,
            pagination: {
                total: total,
                showSizeChanger: true,
                onShowSizeChange(current, pageSize) {
                    dispatch({
                        type: namespaceType,
                        pageable: {
                            page: current - 1,
                            size: pageSize
                        }
                    });
                },
                onChange(current) {
                    dispatch({
                        type: namespaceType,
                        pageable: {
                            page: current - 1
                        }
                    });
                    // self.gotoThispage(current, self.state.queryInfo.pageSize);
                },
                showTotal: function () {
                    return '共 ' + total + ' 条数据';
                }
            }
        };

        return (
            <Table {...tableProps}/>
        );
    }
}

CTable.propTypes = {
    namespaceType: PropTypes.string.isRequired,
    dataSource: PropTypes.array,
    columns: PropTypes.array.isRequired,
    total: PropTypes.number,

    // pagination: PropTypes.boolean,
    bordered: PropTypes.bool,
    loading: PropTypes.bool,

    // rowKey: PropTypes.string | PropTypes.number |  PropTypes.func,
    onRow: PropTypes.func,
    rowSelection: PropTypes.object,
    scroll: PropTypes.shape({
        x: PropTypes.number | PropTypes.bool,
        y: PropTypes.number
    }),
    align: PropTypes.oneOf(['left', 'right', 'center']),
    onChange: PropTypes.func,
};

export default connect()(CTable);