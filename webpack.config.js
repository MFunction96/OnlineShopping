const path = require("path");
const webpack = require("webpack");

module.exports = {
    entry: "./web/js/webpack.js",
    output: {
        filename: "bundle.js",
        path: path.resolve(__dirname, "web/dist")
    },
    plugins: [
        new webpack.ProvidePlugin({
            $: "jquery",
            jQuery: "jquery",
            "window.jQuery": "jquery"
        })
    ],
    module: {
        rules: [
            {
                test: require.resolve("jquery"),
                use: [{
                    loader: "expose-loader",
                    options: "jQuery"
                }, {
                    loader: "expose-loader",
                    options: "$"
                }]
            },
            {
                enforce: "pre",
                test: /\.js$/,
                exclude: /node_modules/,
                loader: "eslint-loader"
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: "babel-loader"
            },
            {
                test: /\.css$/,
                use: [
                    'style-loader',
                    'css-loader'
                ]
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: [
                    'file-loader'
                ]
            },
            {
                test: /\.(woff|woff2|eot|ttf|otf)$/,
                use: [
                    'file-loader'
                ]
            },
            {
                test: /\.xml$/,
                use: [
                    "xml-loader"
                ]
            }
        ]
    }
};