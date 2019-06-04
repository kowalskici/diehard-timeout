### diehard not a great timeout


```
lein repl
```

Then run:
```
(barely-a-timeout)
```

And wait and observe that that executed context is not aborted after exceeding timeout value

Die hard uses failsafe sync execution thus there's no possibility of stopping the executing context after passing timeout value

Underneath .get Supplier interface  method is called 