更详细资料见简书

1，先安装plugman
npm install-g plugman

2，创建cordova项目
plugman create --name #pluginName# --plugin_id #pluginID# --plugin_version #version# [--path ] [--variable NAME=VALUE]

path指的是项目创建的位置

去掉#号，其中方括号内为可选参数

3，添加平台支持
先进入到插件目录下
plugman platform add --platform_name android