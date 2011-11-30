(ns foobarqix-test
  (:use [foobarqix]
        [clojure.test]))

(deftest check-foobarqix
  (testing 
    (are [x y] (= (foobarqix x) y)  
         1 1
         2 2
         3 "FooFoo"
         4 4
         5 "BarBar"
         6 "Foo"
         7 "QixQix"
         8 8
         9 "Foo"
         10 "Bar"
         15 "FooBarBar"
         21 "FooQix"
         33 "FooFooFoo"
         51 "FooBar"
         53 "BarFoo")))
         
         
