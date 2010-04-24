class Spec {
    Number id
    String name
    private String value

    def call(Closure c) {
        identity(c)
    }
   
    def String toString() {
        "$name : $value"
    }
    
    def charge(Closure c) {
        println "CHARGE"
    }
    
    def static process(dsl) {
            new Spec().with {
                $dsl
            }
    }
}

println 'TEST'

spec = new Spec(name: 'spec1')

spec.with {
    value = 'VALUE1'
}
println spec

spec.value = 'VALUE2' //SIC! value is private
println spec

spec {
    name = 'spec3'
    value = 'VALUE3'
}

println spec

config = new File('h:/desktop/charge-conf.dsl').text
spec = Spec.process(config)
println spec
