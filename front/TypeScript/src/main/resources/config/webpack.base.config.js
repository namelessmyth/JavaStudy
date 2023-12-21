const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
	entry: {
		'app': './src/index.ts'
	},
	output: {
		filename: './bundle.js',
		path: path.resolve('dist')
	},
	resolve: {
		extensions: ['.js', '.ts', 'tsx']
	},
	module: {
		rules: [{
			test: /\.tsx?$/i,
			use: [{
				loader: 'ts-loader'
			}],
			exclude: /node_modules/
		}]
	},
	plugins: [
		new HtmlWebpackPlugin({
			template: './src/tpl/index.html'
		})
	]
}
