import {useEffect, useState} from "react";
import TaskContainer from "../components/TaskContainer";

function PathGeneration() {
    // This should be set to be an array as we need to map it to the components
    const [learningPath, setLearningPath] = useState([]);

    useEffect(() => {
        let stringResult = localStorage.getItem("curr");
        setLearningPath(JSON.parse(stringResult));
    }, [])
    return (
        <div>
            <h1>Your Learning Path</h1>
            {/* index is an optional parameter */}
            {learningPath.map((task, index) =>
                <TaskContainer
                    key={index}
                    title={task.title}
                    skill={task.skill}
                    endDate={task.endDate}
                />
            )}
        </div>

    )
}

export default PathGeneration