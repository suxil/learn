module.exports = {
    parser: 'babel-eslint',
    extends: ['eslint:recommended', 'plugin:react/recommended'], //, 'plugin:react/recommended'
    env: {
        browser: true,
        node: true,
        es6: true,
        mocha: true,
        jest: true,
        jasmine: true,
    },
    plugins: [
        'react'
    ],
    parserOptions: {
        ecmaFeatures: {
            jsx: true,
            experimentalObjectRestSpread: true,
        },
    },
    settings: {
        polyfills: ['fetch', 'promises'],
    },
    rules: {
        'no-unused-vars': [1],
        'no-console': [1],

        'react/prop-types': [1],
    },
};
