#cordova插件配置文件plugin.xml的理解
1. 配置文件表头包括了插件id，是用于唯一标识插件的。同时插件配置了一个插件名称。
2. 这个文件从工作机制，也就是js代码一直到native的java插件代码工作分成两个流程。第一个流程是从代码到插件中的js接口文件，第二步是从js接口文件到java插件代码。
2. 首先是第一步，自己写的js代码通过一个require函数来require("plugin-id.js-module-name")来获取到插件js接口，其中第一个参数是插件id，第二个参数是配置文件中js-module标签的name属性。
3. 调用到这个js之后，这个js文件中内容如下：
var exec = require('cordova/exec');
 
exports.toast = function(arg0) {
    exec(null, null, "KKKKUtil", "toast", [arg0]);
};
 
这个文件直接使用了cordova中用来调用native接口的exec函数，通过五个参数中的第二个和第三个唯一定位native代码。其中第二个参数是plugin.xml中的platform android标签中的feature name，这个name下面的param中的value标识了实际提供服务的Native类别名称，这里直接定位至具体类。如下所示：
    <platform name="android">
        <config-file parent="/*" target="res/xml/config.xml">
            <feature name="KKKKUtil">
                <param name="android-package" value="com.hello.intel.plugin.KKKKUtil" />
            </feature>
        </config-file>
这个类的文件是通过添加插件时，plugin中的sourcefile标签去拷贝到对应的java源代码路径下的，如下所示：
<source-file src="src/android/KKKKUtil.java" target-dir="src/com/hello/intel/plugin" />