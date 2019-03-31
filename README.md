# xjsonschema
JSONのスキーマをXMLで定義

仕様もコードもシンプルさを目指した。

## 型
表す型は以下の通り。

* object
* string
* array
* integer
* number
* boolean
* typed-object 型つきobject

## API
JSON型はパッケージプライベートの構造体で表している。これによって不完全ではあるが実用的なイミュータブルを実現している。

APIはファサードを扱うだけにしたい。

## 開発
中心となるXML Schemaは
[xjsonschema/src/main/resources/xjsonschema/](https://github.com/inomoto-hironobu/xjsonschema/tree/master/src/main/resources/xjsonschema)
に置いてある。

参考用及びテスト用のXMLとJSONは
[xjsonschema/src/test/resources/xjsonschema/](https://github.com/inomoto-hironobu/xjsonschema/tree/master/src/test/resources/xjsonschema)
の各ディレクトリいに置いてある。

JUnitでのテストコードを準備している。