����ϸ���ϼ�����

1���Ȱ�װplugman
npm install-g plugman//安装 plugman

2������cordova��Ŀ
plugman create --name #pluginName# --plugin_id #pluginID# --plugin_version #version# [--path ] [--variable NAME=VALUE]

pathָ������Ŀ������λ��

ȥ��#�ţ����з�������Ϊ��ѡ����

3�����ƽ̨֧��
�Ƚ��뵽���Ŀ¼��
plugman platform add --platform_name android

新环境可能会报“Error: Invalid Plugin! /Users/用户名/项目名/插件名 needs a valid package.json”错误，这需要手动添加package.json文件.
(1)cd  到插件里

sudo plugman createpackagejson  【插件路径】／／注意此命令行的格式，“createpackagejson”是无空格的！

（2）一直按回车就可以了，都是在打印package.json文件的内容而已。

（3）查看插件里是不是出现了package.json文件。