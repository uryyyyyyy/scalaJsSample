'use strict';

var webpack = require('webpack');

module.exports = {

    entry: {
        react: './js/react.js',
        material_ui: './js/material-ui.js',
        jquery: "./js/jquery.js",
        myJS: "./js/myJS.js"
    },
    output: {
        path: __dirname + '/generated',
        filename: '[name]-bundle.js'
    }
};