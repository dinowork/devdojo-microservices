package academy.devdojo.youtube.course.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.youtube.core.model.Course;
import academy.devdojo.youtube.course.endpoint.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/admin/course")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {
	
	private final CourseService courseService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Iterable<Course>> list(Pageable pageable){
		log.info("Controller");
		Iterable<Course> list = courseService.list(pageable);		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}	
	
}
