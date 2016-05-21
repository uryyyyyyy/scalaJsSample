'use strict';

var webpack = require('webpack');

module.exports = {

    entry: {
        react_with_addon: './js/react-with-addon.js',
        material_ui: './js/material-ui.js',
        jquery: "./js/jquery.js",
        myJS: "./js/myJS.js"
    },
    output: {
        path: __dirname + '/src/main/resources/generated',
        filename: '[name]-bundle.js'
    }
};