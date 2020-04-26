module.exports = {
  runtimeCompiler: true,
  configureWebpack: {
    // other webpack options to merge in ...
    devtool: 'source-map'
  },
  // devServer Options don't belong into `configureWebpack`
  devServer: {
    //host: '0.0.0.0',
    public: '0.0.0.0:8080',
    hot: true,
    disableHostCheck: true
  },
};