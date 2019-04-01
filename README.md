# xjsonschema
JSONのスキーマをXMLで定義する。

仕様もコードもシンプルさを目指した。

スキーマは型の厳密さを検証する機能のあるTypea(タイピー)と、ごくごくシンプルなTypeb(タイペブ)の2種類がある。

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
JSON型はパッケージプライベートの構造体で表している。これによって不完全ではあるが実用的なイミュータブルを実現している。

公開APIはファサードを扱うだけにしたい。

## 開発
中心となるスキーマXMLのXML Schemaは
[xjsonschema/src/main/resources/xjsonschema/](https://github.com/inomoto-hironobu/xjsonschema/tree/master/src/main/resources/xjsonschema)
に置いてある。

参考用及びテスト用のスキーマXMLとJSONは
[xjsonschema/src/test/resources/xjsonschema/](https://github.com/inomoto-hironobu/xjsonschema/tree/master/src/test/resources/xjsonschema)
の各ディレクトリいに置いてある。

JUnitでのテストコードを準備している。