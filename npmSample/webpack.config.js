'use strict';

var webpack = require('webpack');

module.exports = {

    entry: {
        react: './js/react.js',
        material_ui: './js/material-ui.js'
    },
    output: {
        path: __dirname + '/assets',
        publicPath: "/assets/",
        filename: '[name]-bundle.js'
    }
};