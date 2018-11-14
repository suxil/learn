import React from 'react';

import {
    Form,
} from 'antd';
import CInput from '../input/CInput';

import commonProps from '../../../common/CommonProps';

class COneForm extends React.Component {
    content({form, columns}) {
        columns.forEach((val) => (<CInput form={form} {...val}/>));
    }

    search() {}

    render() {
        const props = this.props;
        const {form, columns} = props;

        let formProps = {...commonProps.formItemProps(), ...props};
        // const columns = [];

        return (
            <div>
                <Form {...formProps}>
                    {this.content({form, columns})}
                    {this.search()}
                </Form>
            </div>
        );
    }
}

export default COneForm;