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
