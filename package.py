import glob
import re
import pathlib
import zipfile

template = "".join(open("./template.xml", "r").readlines())
regex = re.compile(r"^package procon_lib;((&#10;)|\s|import\s+.+;)+public\s+class\s+(?P<class>\w+)\s*\{((&#10;)|\s)+(?P<snippet>.+)\}.*$")
files = glob.glob("./src/main/java/procon_lib/*.java")
for file in files:
    with open(file, "r") as sourceFile:
        code = "".join(sourceFile.readlines()).replace("\n", "&#10;").replace("<", "&lt;").replace(">", "&gt;")
        m = regex.match(code)
        template = template.replace("{"+ m.group("class")  +"}", m.group("snippet"))

with open('./procon.xml','w') as outFile:
    outFile.write(template)

pathlib.Path("./IntelliJ IDEA Global Settings").touch()

with zipfile.ZipFile('settings.zip', 'w', compression=zipfile.ZIP_DEFLATED) as new_zip:
    new_zip.write('procon.xml', arcname='templates/procon.xml')
    new_zip.write('IntelliJ IDEA Global Settings')