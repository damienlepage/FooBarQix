(ns foobarqix)

(def mapping {3 "Foo", 5 "Bar", 7 "Qix"})

(defn contained
  "Returns a sequence where each digit of i is replaced with its 
  corresponding mapping value, or nil"
  [i]
  (for [digit (str i)]
    (mapping (Character/getNumericValue digit))))

(defn divisors
  "Returns a sequence where each mapping key is replaced with its corresponding 
  value or nil, whether it's a divisor of i or not"
  [i]
  (for [[k v] mapping] 
    (when (zero? (rem i k)) v)))

(defn foobarqix 
  "Concatenates and stringifies results of divisors and contained, if any, 
  returns i otherwise"
  [i]
  (let [all ((juxt divisors contained) i)
        res (remove nil? (apply concat all))]
    (if (empty? res) i (reduce str res))))

(defn -main
  ([] (-main 1 100))
  ([x y]
    (doseq [i (range x (inc y))] (-> i foobarqix println))))
