package com.asg;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean //chả về cho IoC 1 bean
	public ModelMapper getModelMapper() {
		ModelMapper mapper= new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		//mapping có 3 cách: lỏng lẽo(LOOSE), tiêu chuẩn(Standard), nghiêm ngặt(STRICT).
		//tìm hiểu thêm tại: https://viblo.asia/p/su-dung-modelmapper-trong-spring-boot-63vKj1Vd52R#_3-vai-dieu-can-luu-y-5
		
		return mapper;
	}
}
