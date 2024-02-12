class LazyProperty(val initializer: () -> Int) {
    private var isInitialized = false
    private var lazyValue: Int = 0
//    var value: Int? = null
    val lazy: Int
        get() {
            if (!isInitialized) {
                lazyValue = initializer()
                isInitialized = true
            }
            return lazyValue
//            if (value == null) {
//                value = initializer()
//            }
//            return value!!
        }
}
