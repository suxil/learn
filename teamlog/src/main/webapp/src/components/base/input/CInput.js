import React from 'react';
import PropTypes from 'prop-types';

import {
    Form,
    Input,
    InputNumber,
    Checkbox,
    Radio,
    Select,
    Switch,
    TreeSelect,
    TimePicker,
    DatePicker,
    AutoComplete,
    Cascader,
    Slider,
    Rate,
    Mention,
    Transfer,
    Upload,

    Col
} from 'antd';
const {MonthPicker, RangePicker, WeekPicker} = DatePicker;
const CheckboxGroup = Checkbox.Group;

const FormItem = Form.Item;

export const inputTypes = [
    'input',
    'number',
    'checkbox',
    'radio',
    'select',
    'switch',
    'tree',
    'time',
    'date',
    'month',
    'range',
    'week',
    'autocomplete',
    'cascader',
    'slider',
    'rate',
    'mention',
    'transfer',
    'upload'
];
const inputTypeNode = {};
inputTypeNode[inputTypes[0]] = Input;
inputTypeNode[inputTypes[1]] = InputNumber;
inputTypeNode[inputTypes[2]] = CheckboxGroup;
inputTypeNode[inputTypes[3]] = Radio;
inputTypeNode[inputTypes[4]] = Select;
inputTypeNode[inputTypes[5]] = Switch;
inputTypeNode[inputTypes[6]] = TreeSelect;
inputTypeNode[inputTypes[7]] = TimePicker;
inputTypeNode[inputTypes[8]] = DatePicker;
inputTypeNode[inputTypes[9]] = MonthPicker;
inputTypeNode[inputTypes[10]] = RangePicker;
inputTypeNode[inputTypes[11]] = WeekPicker;
inputTypeNode[inputTypes[12]] = AutoComplete;
inputTypeNode[inputTypes[13]] = Cascader;
inputTypeNode[inputTypes[14]] = Slider;
inputTypeNode[inputTypes[15]] = Rate;
inputTypeNode[inputTypes[16]] = Mention;
inputTypeNode[inputTypes[17]] = Transfer;
inputTypeNode[inputTypes[18]] = Upload;

import commonProps from '../../../common/CommonProps';

class CInput extends React.Component {
    render () {
        const props = this.props;
        const {inputType, type, label, field, rules, wrapCol = true} = props;
        const {getFieldDecorator} = props.form;

        let placeholder = `请输入${label}`;
        switch (inputType) {
            case inputTypes[4]:
            case inputTypes[8]:
                placeholder = `请选择${label}`;
                break;
            case inputTypes[10]:
                placeholder = ['开始日期', '结束日期'];
                break;
        }
        const inputProps = {placeholder: placeholder, ...commonProps.inputProps(), ...props.inputProps};

        if (type && type === 'hidden') {
            return (
                getFieldDecorator(field, rules)(
                    <Input {...inputProps} type={type} value={props.value}/>
                )
            );
        }

        const formItemProps = {...commonProps.formItem6Props(), ...props.formItemProps, label: label};

        const InputNode = inputTypes.indexOf(inputType) > -1 ? inputTypeNode[inputType] : inputTypeNode[inputTypes[0]];
        const InputNodeItem = (
            <FormItem {...formItemProps}>
                {getFieldDecorator(field, rules)(
                    <InputNode {...inputProps}/>
                )}
            </FormItem>
        );

        if (wrapCol) {
            let colProps = {...commonProps.col6Props(), ...props.colProps};
            return (
                <Col {...colProps}>
                    {InputNodeItem}
                </Col>
            );
        }
        return ({InputNodeItem});
    }
}

CInput.propTypes = {
    type: PropTypes.string,
    form: PropTypes.object.isRequired,
    label: PropTypes.string,
    field: PropTypes.string.isRequired,
    value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    rules: PropTypes.arrayOf(PropTypes.object),
    options: PropTypes.array,
    formItemProps: PropTypes.object,
    inputProps: PropTypes.object,
    inputType: PropTypes.oneOf(inputTypes),
    wrapCol: PropTypes.bool,
    colProps: PropTypes.object,
};

export default CInput;