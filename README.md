# procon-lib

競技プログライング用ライブラリ (Java, IntelliJ IDEA向け)

IntelliJ IDEAのLive template機能を簡単にライブラリコードを挿入できるようにしています。


## ライブラリ一覧

カッコ内はLive templateで使用する略語 (abbreviation)。

- 組合せ (comb)
- モジュラ逆数 (modinv)
- Union Find Tree (uftree)

## 利用方法

### テスト

```
gradle test
```

### パッケージング

```
py package.py 
```

### IntelliJ IDEAへのインポート

パッケージングのコマンドで生成された、`settings.zip`をIntelliJ IDEAへインポートしてください。

インポート方法は[公式マニュアル](https://pleiades.io/help/idea/sharing-live-templates.html#import)を参照。


## ライブラリ追加手順

- `src\main\java\procon_lib`以下に新規にJavaファイルを追加してライブラリを実装する。
  - パッケージング処理時にクラス宣言部分は除去しており、Live templateに登録されるのはクラス宣言の中のコードのみなので注意。
- `template.xml`に追加分ライブラリの記述を追加する。
  - `template`要素の`name`属性にはLive template用の略語を、`value`属性には`{Javaファイル名(拡張子抜き)}`を記述する。
  - 下記は組合せのライブラリの設定例。 (ファイル名:`Combination.java`、略語:`comb`)

``` xml
<template name="comb" value="{Combination}" toReformat="true" toShortenFQNames="true">
    <context>
        <option name="JAVA_DECLARATION" value="true"/>
    </context>
</template>
```


