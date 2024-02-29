import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"
    open fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice,
    val smartdevice: SmartDevice
) {

    var deviceTurnOnCount = 0
        private set
    
    fun turnOnTv() {
        if (smartTvDevice.deviceStatus == "on") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }
    
    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }
    
    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }
    }
    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseVolume()
        }
    }
    
    
    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        }
    }
    fun changeTvChannelToPrevios() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        }
    }
    fun printSmartTvInfo() {
        if (smartTvDevice.deviceStatus == "on") {
            smartdevice.printDeviceInfo()
        }
    }
    fun printSmartLightInfo() {
        if (smartLightDevice.deviceStatus == "on") {
            smartdevice.printDeviceInfo()
        }
    }
    
    fun turnOnLight() {
        if (smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }
    
    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }
    
    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
    }
    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }
    }
    
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}
fun main() {
    val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    smartTvDevice.turnOn()
    smartTvDevice.decreaseVolume()
    smartTvDevice.previousChannel()
    smartTvDevice.printDeviceInfo()

    val smartLightDevice = SmartLightDevice("Google Light", "Utility")
    smartLightDevice.turnOn()
    smartLightDevice.printDeviceInfo()
    smartLightDevice.decreaseBrightness()
}