#IOS添加权限配置

<config-file target="*-Info.plist" parent="NSCameraUsageDescription">
             <string>$CAMERA_USAGE_DESCRIPTION</string>
         </config-file>

         <preference name="PHOTOLIBRARY_USAGE_DESCRIPTION" default=" " />
         <config-file target="*-Info.plist" parent="NSPhotoLibraryUsageDescription">
             <string>$PHOTOLIBRARY_USAGE_DESCRIPTION</string>
         </config-file>

         <config-file target="*-Info.plist" parent="NSLocationWhenInUseUsageDescription">
             <string></string>
         </config-file>
