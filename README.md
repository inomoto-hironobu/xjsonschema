# xSchema
[JSON](https://www.json.org/)、[CSV](https://www.ietf.org/rfc/rfc4180.txt)、[YAML](https://yaml.org/)、x-www-form-urlencodedのスキーマをXMLで定義する。

そしてそのスキーマを活かしたプログラム、つまりデータの検証を行うプログラムを作ることを目指している。

仕様もコードもシンプルさを目指した。

スキーマはJSON向けとしては型の厳密さを検証する機能のあるTypea(タイピー)と、ごくごくシンプルなTypeb(タイペブ)の2種類がある。

他にCSV適応のTypec(タイペック)がある。

YAML対応のTypedを構想中である。

## API
スキーマの定義はパッケージプライベートの構造体で表している。これによって不完全ではあるが実用的なイミュータブルを実現している。

公開APIはファサードを扱うだけにしたい。

## 開発
中心となるスキーマXMLのXML Schemaは
[/src/main/resources/xschema/](https://github.com/inomoto-hironobu/xschema/tree/master/src/main/resources/xschema)
に置いてある。

参考用及びテスト用のスキーマXMLと各種データは
[/src/test/resources/xschema/](https://github.com/inomoto-hironobu/xschema/tree/master/src/test/resources/xschema)
の各ディレクトリいに置いてある。

JUnitでのテストコードを準備している。

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