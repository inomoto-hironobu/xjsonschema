# xSchema
JSON、CSV、YAML、x-www-form-urlencodedのスキーマをXMLで定義する。

そしてそのスキーマを活かしたプログラム、つまりデータの検証を行うプログラムを作ることを目指している。

仕様もコードもシンプルさを目指した。

スキーマはJSON向けとしては型の厳密さを検証する機能のあるTypea(タイピー)と、ごくごくシンプルなTypeb(タイペブ)の2種類がある。

他にCSV適応のTypec(タイペック)がある。

YAML対応のものも構想中である。

## Typeaの型

* object
* string
* array
* integer
* number
* boolean
* 任意の型

## Typebの型

* object
* string
* array
* integer
* number
* boolean

## API
スキーマの定義はパッケージプライベートの構造体で表している。これによって不完全ではあるが実用的なイミュータブルを実現している。

公開APIはファサードを扱うだけにしたい。

## 開発
中心となるスキーマXMLのXML Schemaは
[xschema/src/main/resources/xschema/](https://github.com/inomoto-hironobu/xschema/tree/master/src/main/resources/xschema)
に置いてある。

参考用及びテスト用のスキーマXMLと各種データは
[xchema/src/test/resources/xschema/](https://github.com/inomoto-hironobu/xschema/tree/master/src/test/resources/xschema)
の各ディレクトリいに置いてある。

JUnitでのテストコードを準備している。