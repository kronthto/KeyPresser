# KeyPresser - Hits keys for you

[![Software License][ico-license]](LICENSE.md)
[![Latest Stable Version][ico-githubversion]][link-releases]

This is a really simple app hitting keys in intervals defined by you. Uses [`java.awt.Robot`](https://docs.oracle.com/javase/8/docs/api/java/awt/Robot.html#keyPress-int-).

## Build

``` bash
$ mkdir build
$ javac -d ./build src/de/kronthto/keypresser/*.java
$ cd build
$ jar cfe KeyPresser.jar de.kronthto.keypresser.Program *
```

## Usage

Example: Press key '5' every minute and key 'Z' every 8 seconds:
``` bash
$ java -jar KeyPresser.jar 5 60 z 8
```

## Credits

- [All Contributors][link-contributors]

## License

The MIT License (MIT). Please see the [License File](LICENSE.md) for more information.

[ico-license]: https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square
[ico-githubversion]: https://poser.pugx.org/kronthto/KeyPresser/v/stable

[link-releases]: https://github.com/kronthto/KeyPresser/releases
[link-contributors]: ../../contributors
