

# jdk14-demo
Testing Java 14 features

Sublime build command:

```json
{
	"shell_cmd": "javac --enable-preview $file --release 14 && java -ea --enable-preview $file_base_name",
	"file_regex": "^(...*?):([0-9]*):?([0-9]*)",
	"selector": "source.java",
	"shell": true
}
```
