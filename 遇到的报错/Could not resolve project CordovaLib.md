Error:Unable to resolve dependency for ':@debug/compileClasspath': Could not resolve project :CordovaLib.
<a href="openFile:D:/ionic/ionicdemo/platforms/android/build.gradle">Open File</a><br><a href="Unable to resolve dependency for &#39;:@debug/compileClasspath&#39;: Could not resolve project :CordovaLib.">Show Details</a>




如果你有这类似的错误，可以尝试尝试。

把这种依赖方式

debugCompile project(path: "CordovaLib", configuration: "debug")
releaseCompile project(path: "CordovaLib", configuration: "release")
1
2
改成这种就ok了

implementation project(':CordovaLib')