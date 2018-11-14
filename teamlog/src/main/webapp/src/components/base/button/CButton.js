import React from 'react';
import PropTypes from 'prop-types';

import {
    Button
} from 'antd';

import commonProps from '../../../common/CommonProps';

class CButton extends React.Component {
    render() {
        const props = this.props;
        const {label} = props;
        const {marginl} = props;

        let buttonProps = {...commonProps.buttonProps(), ...props.buttonProps, ...props};

        if (typeof marginl !== 'undefined') {
            buttonProps.style.marginLeft = marginl;
        }

        return (
            <Button {...buttonProps}>{label}</Button>
        );
    }
}

CButton.propTypes = {
    marginl: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    label: PropTypes.string.isRequired,
    buttonProps: PropTypes.object,
};

export default CButton;