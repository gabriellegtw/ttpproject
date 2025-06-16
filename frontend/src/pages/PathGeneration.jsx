import { useNavigate } from "react-router-dom";
import {useEffect, useState} from "react";
import TaskContainer from "../components/TaskContainer";
import axios from "axios";

function PathGeneration() {
    // This should be set to be an array as we need to map it to the components
    const [learningPath, setLearningPath] = useState([]);
    const navigate = useNavigate();

    const handleToggle = (title) => {

        const taskTitle = {
            title: title
        }

        axios.post('http://localhost:8000/roadmap/toggle-task', taskTitle)
            .then(response => {
                console.log("Response for toggle: ", response.data);

                setLearningPath(prev =>
                    prev.map(task =>
                        task.title === title
                            ? { ...task, isCompleted: !task.isCompleted }
                            : task
                    )
                );

                console.log("Current learningPath:", learningPath);

            }).catch(error => console.log("Error: " + error));

    }

    const handleNavigation = (e) => {
        e.preventDefault();
        navigate("/progress");
    }

    // Setting learningPath to be a dependency would cause an infinite loop as the function sets learningPath
    useEffect(() => {
        axios.get('http://localhost:8000/roadmap/roadmap-json')
            .then(response => {
                console.log("Roadmap fetched")
                let parsed = response.data.tasks;

                // Change the String to boolean in isCompleted
                if (parsed && Array.isArray(parsed)) {
                    parsed = parsed.map(task => ({
                        ...task,
                        isCompleted: task.isCompleted === true || task.isCompleted === "true" // convert string "true" to boolean true
                    }));
                }
                setLearningPath(parsed);
            }).catch(error => console.log("Error: " + error));
        // let stringResult = localStorage.getItem("curr");

    }, [])

    return (
        <div>
            <h1>Your Learning Path</h1>
            <button
                onClick={handleNavigation}>
                Navigate to your Progress Page →
            </button>
            {/* index is an optional parameter */}
            {/*This is mapping each of the JSON to the TaskContainer component*/}
            {learningPath.map((task, index) =>
                <TaskContainer
                    key={index}
                    title={task.title}
                    skill={task.skill}
                    endDate={task.endDate}
                    isCompleted={task.isCompleted}
                    // Without the arrow function, the function would immediately execute upon render
                    // In that case, the return value of the function is assigned to handleToggle
                    // Do not in to pass in argument task.title as it is defined in this scope
                    // You would only pass in something if it is not in scope, like for instance, an event object
                    // i.e., a special object created by the browser when something happens in the UI
                    handleToggle={() => handleToggle(task.title)}
                />
            )}
        </div>

    )
}

export default PathGeneration