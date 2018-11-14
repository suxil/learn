import React from 'react';
import 'antd/dist/antd.less';
import zhCN from 'antd/lib/locale-provider/zh_CN';
import {
    LocaleProvider
} from 'antd';

import './BaseLayout.css'

import { Layout, Menu, Icon } from 'antd';
const { Header, Sider, Content, Footer } = Layout;
const { SubMenu, Item, ItemGroup } = Menu;

import { BrowserRouter as Router, Route, Link, NavLink, Redirect, Switch } from "react-router-dom";

import LayoutInterface from './LayoutInterface'

class BaseLayout extends LayoutInterface {
    state = {
        collapsed: false,
    };
    toggle = () => {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    }
    header() {
        return (
            <Header style={{ background: '#fff', padding: 0 }}>
                <Icon
                    className="trigger"
                    type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'}
                    onClick={this.toggle}
                />
            </Header>
        );
    }
    initMenus(parentPath, menus) {
        if (!parentPath) return '';

    }
    sidebar() {
        console.log('sidebar');
        const links = this.props.routerInfo.linkInit((path, link) => {
            return (
                <Item key={path}>
                    <NavLink to={path}>
                        <Icon type="user" />
                        <span>{link.title}</span>
                    </NavLink>
                </Item>
            );
        });
        console.log(links);
        return (
            <Sider
                trigger={null}
                collapsible
                collapsed={this.state.collapsed}
            >
                <div className="logo">
                    <h1>Teamlog Pro</h1>
                </div>
                <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                    {links}
                </Menu>
            </Sider>
        );
    }
    offsidebar() {

    }
    router() {
        console.log('routers');
        const routers = [];
        this.props.routerInfo.routerInit((path, router) => {
            routers.push(
                <Route exact={router.exact}
                       path={path}
                       component={router.component}/>
            );
        });
        routers.push(<Redirect to={'/'}/>);
        console.log(routers);
        return (
            <Layout>
                {this.header()}
                <Content style={{ margin: '12px', background: '#fff', minHeight: 280 }}>
                    <Switch>
                        {routers}
                    </Switch>
                </Content>
                {this.footer()}
            </Layout>
        );
    }
    footer() {
        return (
            <Footer style={{ padding: '5px 50px', height: 35 }}>@ copyright</Footer>
        );
    }
    init() {
        return (
            <Layout>
                {this.sidebar()}
                {this.router()}
            </Layout>
        );
    }
    render() {
        return (
            <Router>
                {this.init()}
            </Router>
        )
    }
}

export default BaseLayout;