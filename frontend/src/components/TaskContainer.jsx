import "./TaskContainer.css";

function TaskContainer( { title, skill, endDate, isCompleted, handleToggle } ) {
    // Cannot just do the below as isCompleted is a prop and not a local state
    // isCompleted = !isCompleted;

    console.log("isCompleted prop:", isCompleted);

    return (
        <div className="task-container">
            <input className="checkbox"
                type="checkbox"
                // isCompleted is passed as a prop of type String
                checked={isCompleted}
                onChange={handleToggle}
            />
            <div className="task-info">
                <p className="task-title">
                    {title}
                </p>
                <p className="additional-info">
                    Associated Skill: {skill}
                </p>
                <p className="additional-info">
                    Deadline: {endDate}
                </p>
            </div>
        </div>
    )
}

export default TaskContainer