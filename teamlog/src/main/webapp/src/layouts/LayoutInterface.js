import React from 'react';
import { BrowserRouter as Router, Route, Link, Redirect } from 'react-router-dom';

export default class LayoutInterface extends React.Component {
    constructor(props) {
        super(props);

    }
    header() {}
    sidebar() {}
    offsidebar() {}
    router() {}
    footer() {}
    init() {}
    render () {
        return (
            <Router>
                {this.init()}
            </Router>
        );
    }
}