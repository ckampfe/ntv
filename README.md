# ntv

This is an example project to do `cljs -> nodejs -> exe`

Prerequisites:

- Boot
- Yarn
- Python >= 2.6 (for [nexe](https://github.com/nexe/nexe))


Use:

```
$ boot setup
$ boot release
$ boot package
$ ./target/out
Hello, World!
```


The `nodejs -> exe` build step is configurable at `scripts/build.js`.

The boot tasks are currently not composable, but I'll do that at some point.
