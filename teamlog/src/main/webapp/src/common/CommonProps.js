import _ from 'lodash';

const config = {
    size: 'small'
};

const commonProps = {
    // 一行四列输入框默认参数
    formItem6Props: () => (
        _.cloneDeep(
            {
                labelCol: {
                    xs: {span: 8},
                    sm: {span: 8},
                },
                wrapperCol: {
                    xs: {span: 16},
                    sm: {span: 16},
                },
            }
        )
    ),
    // 一行两列输入框默认参数
    formItem12Props: () => (
        _.cloneDeep(
            {
                labelCol: {
                    xs: { span: 4 },
                    sm: { span: 4 },
                },
                wrapperCol: {
                    xs: { span: 20 },
                    sm: { span: 20 },
                },
            }
        )
    ),
    // 一行一列输入框默认参数
    formItem24Props: () => (
        _.cloneDeep(
            {
                labelCol: {
                    xs: { span: 3 },
                    sm: { span: 3 },
                },
                wrapperCol: {
                    xs: { span: 21 },
                    sm: { span: 21 },
                },
            }
        )
    ),

    col6Props: () => (
        _.cloneDeep(
            {
                span: 6,
                style: {
                    padding: '0',
                    height: '35px'
                }
            }
        )
    ),
    col8Props: () => (
        _.cloneDeep(
            {
                span: 8,
                style: {
                    padding: '0',
                    height: '35px'
                }
            }
        )
    ),
    col12Props: () => (
        _.cloneDeep(
            {
                span: 12,
                style: {
                    padding: '0',
                    height: '35px'
                }
            }
        )
    ),
    // 搜索行默认参数
    searchColProps: () => (
        _.cloneDeep(
            {
                span: 24,
                style: {
                    textAlign: 'right'
                }
            }
        )
    ),

    cardProps: () => (
        _.cloneDeep(
            {
                bordered: false,
                style: {
                    padding: '0px',
                    marginTop: '2px'
                }
            }
        )
    ),

    inputProps: () => (
        _.cloneDeep(
            {
                size: config.size,
                style: {width: '100%'},
            }
        )
    ),

    firstButtonProps: () => (
        _.cloneDeep(
            {
                size: config.size,
            }
        )
    ),
    buttonProps: () => (
        _.cloneDeep(
            {
                size: config.size,
                style: {
                    marginLeft: '8px'
                },
            }
        )
    ),

    tableProps: () => (
        _.cloneDeep(
            {
                size: config.size,
                //分页
                pagination: {
                    // total: this.state.dataSource.count, //数据总数量
                    // 显示几条一页
                    pageSize: 10,
                    // 默认显示几条一页
                    defaultPageSize: 10,
                    // 是否显示可以设置几条一页的选项
                    showSizeChanger: true,
                }
            }
        )
    )
};

export default commonProps;