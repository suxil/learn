import React from 'react';
import { connect } from 'dva';
import PropTypes from 'prop-types';

import {
    Row,
    Col
} from 'antd';

import CButton from '../button/CButton';

import commonProps from '../../../common/CommonProps';

class CSearch extends React.Component {
    render() {
        const props = this.props;
        const {dispatch, saction, form} = props;
        const {getFieldsValue, resetFields} = form;

        let searchColProps = {...commonProps.searchColProps()};

        const search = () => {
            const param = getFieldsValue();
            dispatch({
                type: saction,
                param: param
            });
        };

        return (
            <Row>
                <Col {...searchColProps}>
                    <CButton first='true' type={'primary'} onClick={() => search()} label={'查询'} />
                    <CButton onClick={() => resetFields()} label={'清空'} />
                </Col>
            </Row>
        );
    }
}

CSearch.propTypes = {
    saction: PropTypes.string.isRequired,
    form: PropTypes.object.isRequired,
};

export default connect()(CSearch);