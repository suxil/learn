import React from 'react';
import { connect } from 'dva';

import {
    Form,
} from 'antd';

import commonProps from '../../../common/CommonProps';

class CForm extends React.Component {
    content() {}

    search() {}

    render() {
        const props = this.props;
        const {form, columns = []} = props;

        let formProps = {...commonProps.formItemProps(), ...props};

        return (
            <Form {...formProps}>
                {this.content({form, columns})}
                {this.search({form})}
            </Form>
        );
    }
}

export default connect()(Form.create()(CForm));