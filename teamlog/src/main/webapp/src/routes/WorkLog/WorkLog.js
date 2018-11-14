import React from 'react';
import {connect} from 'dva';

import './WorkLog.css'

import {
    Card,
    Form,
    Row,
    Col,
    Button,
    Icon,
    Input,
    DatePicker,
    Table
} from 'antd';
import commonProps from '../../common/CommonProps';

const { Item } = Form;

import {
    CInput,
    CButton,
    CSearch
} from '../../components';

import AddWorkLogDialog from './AddWorkLogDialog';

class WorkLog extends React.Component {
    render() {
        const props = this.props;
        const {form} = props;

        const cardProps = {...commonProps.cardProps()};
        const firstButtonProps = {...commonProps.firstButtonProps()};
        const buttonProps = {...commonProps.buttonProps()};

        const columns = [{
            title: '工作日期',
            dataIndex: 'workDate',
        }, {
            title: '开始时间',
            dataIndex: 'startTime',
        }, {
            title: '结束时间',
            dataIndex: 'endTime',
        }, {
            title: '工作时间',
            dataIndex: 'workHours',
        }, {
            title: '工作内容',
            dataIndex: 'content',
        }, {
            title: '工作人',
            dataIndex: 'noteTaker',
        }, {
            title: '所属项目',
            dataIndex: 'category',
        }];

        const tableProps = {
            ...commonProps.tableProps(),
            columns: columns,
            dataSource: [],
        };


        return (
            <div>
                <Card title={'查询'} {...cardProps}>
                    <Form>
                        <Row>
                            <CInput form={form} field={'workDate'} label={'工作日期'}/>
                        </Row>
                        <CSearch form={form} saction={''}/>
                    </Form>
                </Card>
                <Card {...cardProps}>
                    <AddWorkLogDialog/>
                </Card>
                <Card {...cardProps}>
                    <Button type="primary" {...firstButtonProps}><Icon type={'plus'}/>新增</Button>
                    <Button {...buttonProps}><Icon type={'edit'}/>编辑</Button>
                    <Button type="danger" {...buttonProps}><Icon type={'delete'}/>删除</Button>
                </Card>
                <Card {...cardProps}>
                    <Table {...tableProps}/>
                </Card>
            </div>
        )
    }
}

export default connect((worklog) => ({
    worklog
}))(Form.create()(WorkLog));