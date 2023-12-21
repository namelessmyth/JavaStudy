(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
        typeof define === 'function' ? define(factory) :
            (global.Vue = factory());
})(this, function () {
    var ASSET_TYPES = [
        'component',
        'directive',
        'filter'
    ];

    var hasOwnProperty = Object.prototype.hasOwnProperty;

    function hasOwn(obj, key) {
        return hasOwnProperty.call(obj, key)
    }

    var config = ({
        /**
         * Option merge strategies (used in core/util/options)
         */
        // $flow-disable-line
        optionMergeStrategies: Object.create(null)
    });


    /**
     * 默认的策略函数
     */
    var defaultStrat = function (parentVal, childVal) {
        return childVal === undefined ?
            parentVal :
            childVal
    };


    var strats = config.optionMergeStrategies;   // Object.create(null) /  {}

    function mergeOptions(
        parent,
        child,
        vm
    ) {
        var options = {};
        var key;
        for (key in parent) {  //Vue.options  components  directives  filters
            mergeField(key);   //策略处理  选项  默认策略  自定义策略
        }
        for (key in child) {  // options object  el data  
            if (!hasOwn(parent, key)) {
                mergeField(key);
            }
        }

        //strats  {} 自定义的策略函数   defaultStrat默认策略函数
        function mergeField(key) {   //count
            var strat = strats[key] || defaultStrat;
            options[key] = strat(parent[key], child[key], vm, key);     // count
        }
        return options
    }

    function initMixin(Vue) {
        Vue.prototype._init = function (options) {
            var vm = this;
            vm.$options = mergeOptions(   //根组件 el  data {}   其他的组件 el  function(){}
                Vue.options,
                options || {},
                vm
            );
        }
    }

    function initGlobalAPI(Vue) {
        // config
        var configDef = {};
        configDef.get = function () {
            return config;
        }; {
            configDef.set = function () {
                warn(
                    'Do not replace the Vue.config object, set individual fields instead.'
                );
            };
        }
        Object.defineProperty(Vue, 'config', configDef);
    }

    function Vue(options) {
        if (!(this instanceof Vue)) {
            console.error('Vue is a constructor and should be called with the `new` keyword');
        }
        this._init(options);
    }

    Vue.options = Object.create(null);
    //Vue.component
    ASSET_TYPES.forEach(function (type) {
        Vue.options[type + 's'] = Object.create(null);
    });

    initMixin(Vue);
    initGlobalAPI(Vue);
    return Vue;
});