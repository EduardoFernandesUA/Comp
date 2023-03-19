# antlr4 cheat-sheet

build grammar
```antlr4-build```

create Visitor
```antlr4-visitor Hello Execute String```

create Main
```antlr4-main```

create Main with Visitor
```antlr4-main -visitor <VisitorName>```


fast build and run during testing
```antlr4-build && ( echo "hello world" | java HelloWorldMain )```
