import React from 'react';

import {
    Card,
    Form,
    Row,
    Col,
    Button,
    Icon,
    Input,
    DatePicker,
    Table,
    Modal
} from 'antd';
import commonProps from '../../common/CommonProps';

const { Item } = Form;

class AddWorkLogDialog extends React.Component {
    state = {visible: false};

    showModal = () => {
        this.setState({
            visible: true,
        });
    };

    handleOk = (e) => {
        console.log(e);
        this.setState({
            visible: false,
        });
    };

    handleCancel = (e) => {
        console.log(e);
        this.setState({
            visible: false,
        });
    };

    render() {
        const { getFieldDecorator } = this.props.form;

        const cardProps = {...commonProps.cardProps};
        const colProps = {...commonProps.col12Props};
        const searchColProps = {...commonProps.searchColProps};
        const formItem6Props = {...commonProps.formItem6Props};
        const inputProps = {...commonProps.inputProps};
        const firstButtonProps = {...commonProps.firstButtonProps};
        const buttonProps = {...commonProps.buttonProps};

        return (
            <div>
                <Button type="primary" onClick={this.showModal} {...firstButtonProps}><Icon type={'plus'}/>新增</Button>
                <Modal
                    title="Basic Modal"
                    visible={this.state.visible}
                    onOk={this.handleOk}
                    onCancel={this.handleCancel}
                >
                    <Form>
                        <Row>
                            <Col {...colProps}>
                                <Item label={'工作日期:'} {...formItem6Props}>
                                    {getFieldDecorator(`workDate`, {
                                        rules: [{
                                            required: true,
                                        }],
                                    })(
                                        <DatePicker {...inputProps} />
                                    )}
                                </Item>
                            </Col>
                        </Row>
                    </Form>
                </Modal>
            </div>
        )
    }
}

AddWorkLogDialog = Form.create({})(AddWorkLogDialog);
export default AddWorkLogDialog;