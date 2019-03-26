package com.paulmarkcastillo.androidtoolbox.converters

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.DecimalFormat
import kotlin.math.roundToInt

class WeightConverterTest {

    private val weightConverter = WeightConverter()
    private val decimalFormat = DecimalFormat("#.0")
    
    @Test
    fun testConvertLbToKg() {
        assertEquals("22.7", decimalFormat.format(weightConverter.convertLbToKg(50.0)))
        assertEquals("23.1", decimalFormat.format(weightConverter.convertLbToKg(51.0)))
        assertEquals("23.6", decimalFormat.format(weightConverter.convertLbToKg(52.0)))
        assertEquals("24.0", decimalFormat.format(weightConverter.convertLbToKg(53.0)))
        assertEquals("24.5", decimalFormat.format(weightConverter.convertLbToKg(54.0)))
        assertEquals("24.9", decimalFormat.format(weightConverter.convertLbToKg(55.0)))
        assertEquals("25.4", decimalFormat.format(weightConverter.convertLbToKg(56.0)))
        assertEquals("25.9", decimalFormat.format(weightConverter.convertLbToKg(57.0)))
        assertEquals("26.3", decimalFormat.format(weightConverter.convertLbToKg(58.0)))
        assertEquals("26.8", decimalFormat.format(weightConverter.convertLbToKg(59.0)))
        assertEquals("27.2", decimalFormat.format(weightConverter.convertLbToKg(60.0)))
        assertEquals("27.7", decimalFormat.format(weightConverter.convertLbToKg(61.0)))
        assertEquals("28.1", decimalFormat.format(weightConverter.convertLbToKg(62.0)))
        assertEquals("28.6", decimalFormat.format(weightConverter.convertLbToKg(63.0)))
        assertEquals("29.0", decimalFormat.format(weightConverter.convertLbToKg(64.0)))
        assertEquals("29.5", decimalFormat.format(weightConverter.convertLbToKg(65.0)))
        assertEquals("29.9", decimalFormat.format(weightConverter.convertLbToKg(66.0)))
        assertEquals("30.4", decimalFormat.format(weightConverter.convertLbToKg(67.0)))
        assertEquals("30.8", decimalFormat.format(weightConverter.convertLbToKg(68.0)))
        assertEquals("31.3", decimalFormat.format(weightConverter.convertLbToKg(69.0)))
        assertEquals("31.8", decimalFormat.format(weightConverter.convertLbToKg(70.0)))
        assertEquals("32.2", decimalFormat.format(weightConverter.convertLbToKg(71.0)))
        assertEquals("32.7", decimalFormat.format(weightConverter.convertLbToKg(72.0)))
        assertEquals("33.1", decimalFormat.format(weightConverter.convertLbToKg(73.0)))
        assertEquals("33.6", decimalFormat.format(weightConverter.convertLbToKg(74.0)))
        assertEquals("34.0", decimalFormat.format(weightConverter.convertLbToKg(75.0)))
        assertEquals("34.5", decimalFormat.format(weightConverter.convertLbToKg(76.0)))
        assertEquals("34.9", decimalFormat.format(weightConverter.convertLbToKg(77.0)))
        assertEquals("35.4", decimalFormat.format(weightConverter.convertLbToKg(78.0)))
        assertEquals("35.8", decimalFormat.format(weightConverter.convertLbToKg(79.0)))
        assertEquals("36.3", decimalFormat.format(weightConverter.convertLbToKg(80.0)))
        assertEquals("36.7", decimalFormat.format(weightConverter.convertLbToKg(81.0)))
        assertEquals("37.2", decimalFormat.format(weightConverter.convertLbToKg(82.0)))
        assertEquals("37.6", decimalFormat.format(weightConverter.convertLbToKg(83.0)))
        assertEquals("38.1", decimalFormat.format(weightConverter.convertLbToKg(84.0)))
        assertEquals("38.6", decimalFormat.format(weightConverter.convertLbToKg(85.0)))
        assertEquals("39.0", decimalFormat.format(weightConverter.convertLbToKg(86.0)))
        assertEquals("39.5", decimalFormat.format(weightConverter.convertLbToKg(87.0)))
        assertEquals("39.9", decimalFormat.format(weightConverter.convertLbToKg(88.0)))
        assertEquals("40.4", decimalFormat.format(weightConverter.convertLbToKg(89.0)))
        assertEquals("40.8", decimalFormat.format(weightConverter.convertLbToKg(90.0)))
        assertEquals("41.3", decimalFormat.format(weightConverter.convertLbToKg(91.0)))
        assertEquals("41.7", decimalFormat.format(weightConverter.convertLbToKg(92.0)))
        assertEquals("42.2", decimalFormat.format(weightConverter.convertLbToKg(93.0)))
        assertEquals("42.6", decimalFormat.format(weightConverter.convertLbToKg(94.0)))
        assertEquals("43.1", decimalFormat.format(weightConverter.convertLbToKg(95.0)))
        assertEquals("43.5", decimalFormat.format(weightConverter.convertLbToKg(96.0)))
        assertEquals("44.0", decimalFormat.format(weightConverter.convertLbToKg(97.0)))
        assertEquals("44.5", decimalFormat.format(weightConverter.convertLbToKg(98.0)))
        assertEquals("44.9", decimalFormat.format(weightConverter.convertLbToKg(99.0)))
        assertEquals("45.4", decimalFormat.format(weightConverter.convertLbToKg(100.0)))
        assertEquals("45.8", decimalFormat.format(weightConverter.convertLbToKg(101.0)))
        assertEquals("46.3", decimalFormat.format(weightConverter.convertLbToKg(102.0)))
        assertEquals("46.7", decimalFormat.format(weightConverter.convertLbToKg(103.0)))
        assertEquals("47.2", decimalFormat.format(weightConverter.convertLbToKg(104.0)))
        assertEquals("47.6", decimalFormat.format(weightConverter.convertLbToKg(105.0)))
        assertEquals("48.1", decimalFormat.format(weightConverter.convertLbToKg(106.0)))
        assertEquals("48.5", decimalFormat.format(weightConverter.convertLbToKg(107.0)))
        assertEquals("49.0", decimalFormat.format(weightConverter.convertLbToKg(108.0)))
        assertEquals("49.4", decimalFormat.format(weightConverter.convertLbToKg(109.0)))
        assertEquals("49.9", decimalFormat.format(weightConverter.convertLbToKg(110.0)))
        assertEquals("50.3", decimalFormat.format(weightConverter.convertLbToKg(111.0)))
        assertEquals("50.8", decimalFormat.format(weightConverter.convertLbToKg(112.0)))
        assertEquals("51.3", decimalFormat.format(weightConverter.convertLbToKg(113.0)))
        assertEquals("51.7", decimalFormat.format(weightConverter.convertLbToKg(114.0)))
        assertEquals("52.2", decimalFormat.format(weightConverter.convertLbToKg(115.0)))
        assertEquals("52.6", decimalFormat.format(weightConverter.convertLbToKg(116.0)))
        assertEquals("53.1", decimalFormat.format(weightConverter.convertLbToKg(117.0)))
        assertEquals("53.5", decimalFormat.format(weightConverter.convertLbToKg(118.0)))
        assertEquals("54.0", decimalFormat.format(weightConverter.convertLbToKg(119.0)))
        assertEquals("54.4", decimalFormat.format(weightConverter.convertLbToKg(120.0)))
        assertEquals("54.9", decimalFormat.format(weightConverter.convertLbToKg(121.0)))
        assertEquals("55.3", decimalFormat.format(weightConverter.convertLbToKg(122.0)))
        assertEquals("55.8", decimalFormat.format(weightConverter.convertLbToKg(123.0)))
        assertEquals("56.2", decimalFormat.format(weightConverter.convertLbToKg(124.0)))
        assertEquals("56.7", decimalFormat.format(weightConverter.convertLbToKg(125.0)))
        assertEquals("57.2", decimalFormat.format(weightConverter.convertLbToKg(126.0)))
        assertEquals("57.6", decimalFormat.format(weightConverter.convertLbToKg(127.0)))
        assertEquals("58.1", decimalFormat.format(weightConverter.convertLbToKg(128.0)))
        assertEquals("58.5", decimalFormat.format(weightConverter.convertLbToKg(129.0)))
        assertEquals("59.0", decimalFormat.format(weightConverter.convertLbToKg(130.0)))
        assertEquals("59.4", decimalFormat.format(weightConverter.convertLbToKg(131.0)))
        assertEquals("59.9", decimalFormat.format(weightConverter.convertLbToKg(132.0)))
        assertEquals("60.3", decimalFormat.format(weightConverter.convertLbToKg(133.0)))
        assertEquals("60.8", decimalFormat.format(weightConverter.convertLbToKg(134.0)))
        assertEquals("61.2", decimalFormat.format(weightConverter.convertLbToKg(135.0)))
        assertEquals("61.7", decimalFormat.format(weightConverter.convertLbToKg(136.0)))
        assertEquals("62.1", decimalFormat.format(weightConverter.convertLbToKg(137.0)))
        assertEquals("62.6", decimalFormat.format(weightConverter.convertLbToKg(138.0)))
        assertEquals("63.0", decimalFormat.format(weightConverter.convertLbToKg(139.0)))
        assertEquals("63.5", decimalFormat.format(weightConverter.convertLbToKg(140.0)))
        assertEquals("64.0", decimalFormat.format(weightConverter.convertLbToKg(141.0)))
        assertEquals("64.4", decimalFormat.format(weightConverter.convertLbToKg(142.0)))
        assertEquals("64.9", decimalFormat.format(weightConverter.convertLbToKg(143.0)))
        assertEquals("65.3", decimalFormat.format(weightConverter.convertLbToKg(144.0)))
        assertEquals("65.8", decimalFormat.format(weightConverter.convertLbToKg(145.0)))
        assertEquals("66.2", decimalFormat.format(weightConverter.convertLbToKg(146.0)))
        assertEquals("66.7", decimalFormat.format(weightConverter.convertLbToKg(147.0)))
        assertEquals("67.1", decimalFormat.format(weightConverter.convertLbToKg(148.0)))
        assertEquals("67.6", decimalFormat.format(weightConverter.convertLbToKg(149.0)))
        assertEquals("68.0", decimalFormat.format(weightConverter.convertLbToKg(150.0)))
    }

    @Test
    fun testConvertKgToLb() {
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(22.7).roundToInt()),"50.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(23.1).roundToInt()),"51.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(23.6).roundToInt()),"52.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(24.0).roundToInt()),"53.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(24.5).roundToInt()),"54.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(24.9).roundToInt()),"55.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(25.4).roundToInt()),"56.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(25.9).roundToInt()),"57.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(26.3).roundToInt()),"58.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(26.8).roundToInt()),"59.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(27.2).roundToInt()),"60.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(27.7).roundToInt()),"61.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(28.1).roundToInt()),"62.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(28.6).roundToInt()),"63.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(29.0).roundToInt()),"64.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(29.5).roundToInt()),"65.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(29.9).roundToInt()),"66.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(30.4).roundToInt()),"67.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(30.8).roundToInt()),"68.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(31.3).roundToInt()),"69.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(31.8).roundToInt()),"70.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(32.2).roundToInt()),"71.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(32.7).roundToInt()),"72.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(33.1).roundToInt()),"73.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(33.6).roundToInt()),"74.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(34.0).roundToInt()),"75.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(34.5).roundToInt()),"76.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(34.9).roundToInt()),"77.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(35.4).roundToInt()),"78.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(35.8).roundToInt()),"79.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(36.3).roundToInt()),"80.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(36.7).roundToInt()),"81.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(37.2).roundToInt()),"82.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(37.6).roundToInt()),"83.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(38.1).roundToInt()),"84.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(38.6).roundToInt()),"85.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(39.0).roundToInt()),"86.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(39.5).roundToInt()),"87.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(39.9).roundToInt()),"88.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(40.4).roundToInt()),"89.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(40.8).roundToInt()),"90.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(41.3).roundToInt()),"91.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(41.7).roundToInt()),"92.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(42.2).roundToInt()),"93.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(42.6).roundToInt()),"94.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(43.1).roundToInt()),"95.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(43.5).roundToInt()),"96.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(44.0).roundToInt()),"97.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(44.5).roundToInt()),"98.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(44.9).roundToInt()),"99.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(45.4).roundToInt()),"100.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(45.8).roundToInt()),"101.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(46.3).roundToInt()),"102.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(46.7).roundToInt()),"103.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(47.2).roundToInt()),"104.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(47.6).roundToInt()),"105.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(48.1).roundToInt()),"106.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(48.5).roundToInt()),"107.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(49.0).roundToInt()),"108.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(49.4).roundToInt()),"109.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(49.9).roundToInt()),"110.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(50.3).roundToInt()),"111.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(50.8).roundToInt()),"112.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(51.3).roundToInt()),"113.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(51.7).roundToInt()),"114.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(52.2).roundToInt()),"115.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(52.6).roundToInt()),"116.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(53.1).roundToInt()),"117.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(53.5).roundToInt()),"118.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(54.0).roundToInt()),"119.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(54.4).roundToInt()),"120.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(54.9).roundToInt()),"121.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(55.3).roundToInt()),"122.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(55.8).roundToInt()),"123.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(56.2).roundToInt()),"124.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(56.7).roundToInt()),"125.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(57.2).roundToInt()),"126.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(57.6).roundToInt()),"127.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(58.1).roundToInt()),"128.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(58.5).roundToInt()),"129.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(59.0).roundToInt()),"130.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(59.4).roundToInt()),"131.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(59.9).roundToInt()),"132.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(60.3).roundToInt()),"133.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(60.8).roundToInt()),"134.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(61.2).roundToInt()),"135.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(61.7).roundToInt()),"136.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(62.1).roundToInt()),"137.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(62.6).roundToInt()),"138.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(63.0).roundToInt()),"139.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(63.5).roundToInt()),"140.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(64.0).roundToInt()),"141.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(64.4).roundToInt()),"142.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(64.9).roundToInt()),"143.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(65.3).roundToInt()),"144.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(65.8).roundToInt()),"145.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(66.2).roundToInt()),"146.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(66.7).roundToInt()),"147.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(67.1).roundToInt()),"148.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(67.6).roundToInt()),"149.0")
        assertEquals(decimalFormat.format(weightConverter.convertKgToLb(68.0).roundToInt()),"150.0")
    }
}