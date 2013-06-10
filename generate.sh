#!/bin/bash

thrift -r --gen java -out src/main/java src/main/thrift/game.thrift
thrift -r --gen py -out src/main/python src/main/thrift/game.thrift

