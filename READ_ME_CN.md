# 版本
cas 7.0 + jdk21
# 创建密钥
.\gradlew.bat createKeystore
在gradle.properties文件里面可以修改密钥文件生成的地址
# 密钥使用地址
在application.yml文件里面配置即可
# 配置数据库查询密码
./src/main/resources/application.yml文件中修改数据库配置即可
# 页面信息的显示
若要修改页面上显示的信息，或者是返回的错误信息，请修改./src/main/resources/messages_zh_CN.properties文件中的内容；
Spring Boot / CAS 的国际化（i18n）机制
# 添加cas-client
在./etc/cas/services目录下，可以创建对应的文件，开放对应的cas客户端
# cas-client客户端配置crt密钥
找到第一步生成的密钥：cas.crt文件
进入含有cas.crt文件的目录下面执行下面的命令
`keytool -importcert -file cas.crt -keystore "D:\develop\Java21\lib\security\cacerts" -alias "cas-server"`
默认密码是：changeit
不添加密钥的话：http://localhost:1000/login?ticket=ST-4-Ni-zzjc8HpB6S5QcwHHRJmcvGoQ-liusaidh行不通
cas-client显示会错误信息
# cas-client删除刚才添加的密钥
keytool -delete -alias cas-server -keystore "D:\develop\Java21\lib\security\cacerts"
