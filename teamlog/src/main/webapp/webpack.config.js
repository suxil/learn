const path = require('path');

const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

console.log('node-env: ' + process.env.NODE_ENV);

const pkg = require(path.resolve(__dirname, 'package.json'));

let theme = {};
if (pkg.theme && typeof(pkg.theme) === 'string') {
    let cfgPath = pkg.theme;
    // relative path
    if (cfgPath.charAt(0) === '.') {
        cfgPath = path.resolve(__dirname, cfgPath);
    }
    theme = require(cfgPath);
} else if (pkg.theme && typeof(pkg.theme) === 'object') {
    theme = pkg.theme;
}

let config = {
    mode: process.env.NODE_ENV === 'production' ? process.env.NODE_ENV : 'development',
    entry: './src/index.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: process.env.NODE_ENV === 'production' ? '[name].[hash].bundle.js' : '[name].bundle.js',
        library: "MyLibrary",
        libraryTarget: "umd",
    },
    optimization: {
        splitChunks: {
            chunks: 'all',
            minSize: 30000,
            minChunks: 1,
            cacheGroups: {
                vendors: {
                    name: 'vendors',
                    test: /[\\/]node_modules[\\/]/,
                    priority: 10
                },
            }
        }
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: "[name].css",
            chunkFilename: "[id].css"
        })
    ],
    externals: {
    },
    resolve: {
        extensions: ['.wasm', '.mjs', '.js', '.jsx', '.json']
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader'
                }
            },
            {
                test: /\.css$/,
                use: [ MiniCssExtractPlugin.loader, 'css-loader' ]
            },
            {
                test: /\.(png|jpg|gif)$/,
                use: 'url-loader?limit=100000',
            },
            {
                test: /\.woff|\.woff2|\.svg|.eot|\.ttf/,
                use: 'url-loader?prefix=font/&limit=200000&name=fonts/[name].[ext]',
            },
            {
                test: /\.less$/,
                use: [{
                    loader: 'style-loader'
                }, {
                    loader: 'css-loader'
                }, {
                    loader: 'less-loader',
                    options: {
                        javascriptEnabled: true,
                        modifyVars: theme
                    }
                }]
            },
        ]
    }
};

if (process.env.NODE_ENV === 'production') {
    config.plugins.push(
        new CopyWebpackPlugin([
            {
                from: path.resolve(__dirname, './src'),
                to: path.resolve(__dirname, './es'),
                force: true,
                toType: 'dir',
                ignore: ['.*', './src/angle']
            }
        ], {
        }),
    );
} else {
    if (process.env.NODE_ENV === 'dev') {
        config.devServer = {
            historyApiFallback: true,
            contentBase: path.join(__dirname, 'dist'),
            compress: true,
            port: 9101,
            hot: true,
            watchOptions: {
                aggregateTimeout: 300,
                poll: 300,
            }
        };
    }
    config.entry = './src/index.js';
    config.devtool = 'source-map ';
    config.plugins.push(
        new HtmlWebpackPlugin({
            title: 'Teamlog App',
            template: './public/index.html'
        })
    );
}

module.exports = config;