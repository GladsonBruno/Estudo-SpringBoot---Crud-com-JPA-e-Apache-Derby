package io.javabrains.springbootstater.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId){
		
		List<Lesson> lessonList = new ArrayList<Lesson>();
		lessonRepository.findByCourseId(courseId).forEach(lessonList::add);
		return lessonList;
	}
	
	public Lesson getLesson(String lessonId) {
		
		return lessonRepository.findById(lessonId).get();
		
	}
	
	public void addLesson(Lesson newLesson) {
	
		lessonRepository.save(newLesson);
		
	}
	
	public void updateLesson(Lesson updatedLesson) {
		
		lessonRepository.save(updatedLesson);
		
	}
	
	public void deleteLesson(String lessonId) {
	
		lessonRepository.deleteById(lessonId);
		
	}
	
}
